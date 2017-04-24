package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.UserRepository;

import javax.servlet.http.HttpSession;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */

@Controller
@SessionAttributes("user")
public class IndexController {

    private final UserRepository userRepository;

    @Autowired
    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model, HttpSession httpSession) {

        User newUser = userRepository.findUserByName("test");
        System.out.println(newUser);
        model.addAttribute("user", newUser);
        httpSession.setAttribute("user", newUser);
        return "index";
    }

}
