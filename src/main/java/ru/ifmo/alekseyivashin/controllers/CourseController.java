package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.*;
import ru.ifmo.alekseyivashin.services.CourseService;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

/**
 * Creator: aleks
 * Date:    14.05.17
 */

@Controller
@RequestMapping("/course")
public class CourseController {


    private final TestRepository testRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserCourseRepository userCourseRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;


    @Autowired
    public CourseController(TestRepository testRepository, AnswerRepository answerRepository, QuestionRepository questionRepository, UserCourseRepository userCourseRepository, CourseRepository courseRepository, CourseService courseService) {
        this.testRepository = testRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userCourseRepository = userCourseRepository;
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    @RequestMapping(value = "{courseId}/welcome", method = RequestMethod.GET)
    String welcomePage(@PathVariable int courseId,
                       HttpSession session,
                       Model model) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        UserCourse userCourse = userCourseRepository.getUserCourse(user.getId(), course.getId());
        if (user == null) {
            return "redirect:/";
        }
        if (userCourse != null && userCourse.getProgress() == 1) {
            model.addAttribute("progressMessage", "Вы уже прошли данный курс!");
        }
        model.addAttribute("course", courseRepository.findOne(courseId));
        return "course/welcome";
    }

    @RequestMapping(value = "/{courseId}/check", method = RequestMethod.GET)
    String chooseCoursePage(HttpSession session,
                            @PathVariable int courseId,
                            RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        UserCourse userCourse = userCourseRepository.getUserCourse(user.getId(), course.getId());
        if (userCourse == null) {
            courseService.createAndSaveUserCourseObject(user, course);
        }
        return "redirect:/course/{courseId}/test?type=start";
    }

    @RequestMapping(value = "{courseId}/test", params = {"type"}, method = RequestMethod.GET)
    String testPage(@PathVariable int courseId,
                    @RequestParam String type,
                    Model model) {
        Course course = courseRepository.findOne(courseId);
        if (type.equals("start")) {
            Test startTest = courseService.getTestByType(course, TestType.START);
            model.addAttribute("test", startTest);
        }
        return "course/test";
    }

    @RequestMapping(value = "/learning", method = RequestMethod.GET)
    String learningPage() {
        return "course/learning";
    }

    @RequestMapping(value = "/final", method = RequestMethod.GET)
    String finalPage() {
        return "course/final";
    }
}
