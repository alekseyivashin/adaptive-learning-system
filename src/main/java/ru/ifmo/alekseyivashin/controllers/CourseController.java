package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import ru.ifmo.alekseyivashin.services.WaySelectionService;

import javax.servlet.http.HttpSession;

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


    @Autowired
    public CourseController(UserCourseRepository userCourseRepository, CourseRepository courseRepository, CourseService courseService, WaySelectionService waySelectionService) {
        this.userCourseRepository = userCourseRepository;
        this.courseRepository = courseRepository;
        this.courseService = courseService;
        this.waySelectionService = waySelectionService;
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

    @RequestMapping(value = "{courseId}/test", params = {"type"}, method = RequestMethod.GET)
    String testPage(HttpSession session,
                    @PathVariable int courseId,
                    @RequestParam String type,
                    Model model) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);
        UserCourse userCourse = userCourseRepository.findByUserAndCourse(user, course);

        Test test = waySelectionService.selectTest(userCourse, type);
        model.addAttribute("test", test);
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
