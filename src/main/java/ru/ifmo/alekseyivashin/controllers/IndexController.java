package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.UserRepository;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index(Model model) {
        User user = new User();
        user.setName("test");
        user.setPassword("password");
        System.out.println(user);
//        userRepository.save(user);

        User newUser = userRepository.findUserByName("test");
        System.out.println(newUser);
        model.addAttribute("user", newUser);
        return "index";
    }
}
