package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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
    String index(HttpSession session) {
        return "index";
    }

}
