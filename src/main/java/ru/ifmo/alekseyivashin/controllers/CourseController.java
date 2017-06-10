package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.LectureRepository;
import ru.ifmo.alekseyivashin.repositories.RatingRepository;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.services.CourseService;
import ru.ifmo.alekseyivashin.services.TestService;
import ru.ifmo.alekseyivashin.services.WaySelectionService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Creator: aleks
 * Date:    14.05.17
 */

@Controller
@RequestMapping("/course")
public class CourseController {


    private final UserCourseRepository userCourseRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;
    private final WaySelectionService waySelectionService;
    private final TestService testService;
    private final LectureRepository lectureRepository;
    private final RatingRepository ratingRepository;


    @Autowired
    public CourseController(UserCourseRepository userCourseRepository,
                            CourseRepository courseRepository,
                            CourseService courseService,
                            WaySelectionService waySelectionService,
                            TestService testService,
                            LectureRepository lectureRepository,
                            RatingRepository ratingRepository) {
        this.userCourseRepository = userCourseRepository;
        this.courseRepository = courseRepository;
        this.courseService = courseService;
        this.waySelectionService = waySelectionService;
        this.testService = testService;
        this.lectureRepository = lectureRepository;
        this.ratingRepository = ratingRepository;
    }

    @RequestMapping(value = "{courseId}/welcome", method = RequestMethod.GET)
    String welcomePage(@PathVariable int courseId,
                       HttpSession session,
                       Model model) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        if (user == null) {
            return "redirect:/";
        }
        UserCourse userCourse = userCourseRepository.findByUserAndCourse(user, course);
        if (userCourse != null && userCourse.getProgress() == 1) {
            model.addAttribute("progressMessage", "Вы уже прошли данный курс!");
        }
        model.addAttribute("course", courseRepository.findOne(courseId));
        return "course/welcome";
    }

    @RequestMapping(value = "/{courseId}/select", method = RequestMethod.GET)
    String chooseCoursePage(HttpSession session,
                            @PathVariable int courseId,
                            RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        if (userCourseRepository.findByUserAndCourse(user, course) == null) {
            courseService.createAndSaveUserCourseObject(user, course);
        }
        UserCourse userCourse = userCourseRepository.findByUserAndCourse(user, course);
        return waySelectionService.selectWay(userCourse);
    }

    @RequestMapping(value = "{courseId}/test", params = {"type", "lectureId"}, method = RequestMethod.GET)
    String testPage(HttpSession session,
                    @PathVariable int courseId,
                    @RequestParam String type,
                    @RequestParam String lectureId,
                    Model model) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        UserCourse userCourse = userCourseRepository.findByUserAndCourse(user, course);
        Lecture lecture = null;
        if (!lectureId.equals("null")) {
            lecture = lectureRepository.findOne(convertToInt(lectureId));
        }

        Test test = waySelectionService.selectTest(userCourse, type, lecture);
        test.getQuestions().forEach(question -> question.getAnswers().forEach(answer -> answer.setCorrect(false)));
        model.addAttribute("test", test);
        return "course/test";
    }

    @RequestMapping(value = "{courseId}/test", method = RequestMethod.POST)
    String testSubmit(HttpSession session,
                      @ModelAttribute("test") Test userTest,
                      @PathVariable int courseId) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        UserCourse userCourse = userCourseRepository.findByUserAndCourse(user, course);

        testService.checkTest(userCourse, userTest);
        return "redirect:/course/{courseId}/select";
    }

    @RequestMapping(value = "{courseId}/lecture/{lectureId}", method = RequestMethod.GET)
    String lecturePage(@PathVariable int courseId,
                       @PathVariable int lectureId,
                       Model model) {
        model.addAttribute("lecture", lectureRepository.findOne(lectureId));
        return "course/lecture";
    }

    @RequestMapping(value = "{courseId}/lecture/{lectureId}/submit", method = RequestMethod.GET)
    String lectureSubmit(@PathVariable int courseId,
                         @PathVariable int lectureId) {
        return "redirect:/course/{courseId}/test?type=medium&lectureId={lectureId}";
    }

    @RequestMapping(value = "{courseId}/final", method = RequestMethod.GET)
    String finalPage(HttpSession session,
                     @PathVariable int courseId,
                     Model model) {
        model.addAttribute("course", courseRepository.findOne(courseId));
        return "course/final";
    }

    @RequestMapping(value = "{courseId}/final", method = RequestMethod.POST)
    String finalSubmit(HttpSession session,
                       @PathVariable int courseId,
                       @RequestParam Integer rating,
                       @RequestParam Integer accuracy,
                       @RequestParam Integer complexity) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        UserCourse userCourse = userCourseRepository.findByUserAndCourse(user, course);

        course.setRating((course.getRating() * (course.getUserCount() - 1) + rating) / course.getUserCount());
        courseRepository.save(course);

        userCourse.setEndDate(new Date());
        userCourse.setRating(rating);
        userCourse.setProgress(1.0);
        userCourseRepository.save(userCourse);

        Rating ratingEntity = new Rating();
        ratingEntity.setUserCourse(userCourse);
        ratingEntity.setCommon(rating);
        ratingEntity.setAccuracy(accuracy);
        ratingEntity.setComplexity(complexity);
        ratingRepository.save(ratingEntity);
        return "redirect:/";
    }

    private Integer convertToInt(String s) {
        if (s.equals("null") || s.equals("")) return null;
        return Integer.valueOf(s);
    }
}
