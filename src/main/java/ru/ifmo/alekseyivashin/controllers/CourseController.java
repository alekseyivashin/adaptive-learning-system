package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ifmo.alekseyivashin.repositories.AnswerRepository;
import ru.ifmo.alekseyivashin.repositories.QuestionRepository;
import ru.ifmo.alekseyivashin.repositories.TestRepository;

import javax.servlet.http.HttpSession;

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


    @Autowired
    public CourseController(TestRepository testRepository, AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.testRepository = testRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String chooseCoursePage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        }
        return "redirect:/course/welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    String welcomePage() {
        return "course/welcome";
    }
}
