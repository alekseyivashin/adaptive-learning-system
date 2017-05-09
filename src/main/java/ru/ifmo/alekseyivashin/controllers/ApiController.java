package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.UserRepository;

import java.util.List;

/**
 * Creator: aleks
 * Date:    08.05.17
 */

@Controller
@RequestMapping("/api")
public class ApiController {


    private final UserRepository userRepository;

    @Autowired
    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
