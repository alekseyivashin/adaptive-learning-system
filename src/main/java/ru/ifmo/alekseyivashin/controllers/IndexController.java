package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserRepository;

import javax.servlet.http.HttpSession;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */

@Controller
@SessionAttributes("user")
public class IndexController {

    private final UserRepository   userRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public IndexController(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model, HttpSession session) {
        model.addAttribute("courses", courseRepository.findAll());
        return "index";
    }

}
