package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
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


    @Autowired
    public CourseController(TestRepository testRepository, AnswerRepository answerRepository, QuestionRepository questionRepository, UserCourseRepository userCourseRepository, CourseRepository courseRepository) {
        this.testRepository = testRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userCourseRepository = userCourseRepository;
        this.courseRepository = courseRepository;
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    String chooseCoursePage(HttpSession session,
                            @PathVariable int courseId) {
        User user = (User) session.getAttribute("user");
        Course course = courseRepository.findOne(courseId);

        if (user == null) {
            return "redirect:/";
        }

        UserCourse userCourse = userCourseRepository.getUserCourse(user.getId(), course.getId());
        if (userCourse == null) {
            userCourse = new UserCourse();
            userCourse.setUser(user);
            userCourse.setCourse(course);
            userCourse.setStartDate(new Date());
            userCourse.setProgress(0f);
            userCourseRepository.save(userCourse);
            return "redirect:/course/{courseId}/welcome";
        } else {
            if (userCourse.getStartScore() == null) {
                return "redirect:/course/{courseId}/test/?type=start";
            }
        }
        return "redirect:/";
    }

    @RequestMapping(value = "{courseId}/welcome", method = RequestMethod.GET)
    String welcomePage(@PathVariable int courseId,
                       Model model) {
        model.addAttribute("course", courseRepository.findOne(courseId));
        return "course/welcome";
    }

    @RequestMapping(value = "{courseId}/test", params = {"type"}, method = RequestMethod.GET)
    String testPage(@PathVariable int courseId,
                    @RequestParam String type,
                    Model model) {
        Course course = courseRepository.findOne(courseId);
        if (type.equals("start")) {
            Test startTest = course.getTests()
                    .stream()
                    .filter(test -> test.getType().equals(TestType.START))
                    .collect(Collectors.toList())
                    .get(0);
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
