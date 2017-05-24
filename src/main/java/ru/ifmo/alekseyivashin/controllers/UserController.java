package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.ifmo.alekseyivashin.messages.Message;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserRepository;
import ru.ifmo.alekseyivashin.services.AuthService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created on : 25.04.2017
 * Author     : aliv0816
 */

@Controller
@RequestMapping("/user")
//@SessionAttributes("user")
public class UserController {

    private final AuthService authService;
    private final UserCourseRepository userCourseRepository;
    private final UserRepository userRepository;


    @Autowired
    public UserController(AuthService authService, UserCourseRepository userCourseRepository, UserRepository userRepository) {
        this.authService = authService;
        this.userCourseRepository = userCourseRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    String signupPage(User user) {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    String signupForm(Model model,
                      @ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult) {
        System.out.println(user);
        if (!bindingResult.hasErrors()) {
            Message message = authService.signUp(user);
            if (!message.getStatus().equals(Message.Status.ERROR)) {
                return "redirect:/";
            } else {
                model.addAttribute("error", message.getMessage());
            }
        }
        return "signup";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    String signinPage(User user) {
        return "signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    String signinForm(Model model,
                      @ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult,
                      HttpSession session) {
        if (!bindingResult.hasErrors()) {
            Message message = authService.signIn(user);
            if (!message.getStatus().equals(Message.Status.ERROR)) {
                session.setAttribute("user", userRepository.findUserByName(user.getName()));
                return "redirect:/profile";
            } else {
                model.addAttribute("error", message.getMessage());
            }
        }
        model.addAttribute("user", user);
        return "signin";
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    String signout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    String profile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("userCoursesInProgress", userCourseRepository.getUserCoursesInProgress(user.getId()));
        model.addAttribute("userFinishedCourses", userCourseRepository.getFinishedUserCourses(user.getId()));
        return "profile";
    }
}
