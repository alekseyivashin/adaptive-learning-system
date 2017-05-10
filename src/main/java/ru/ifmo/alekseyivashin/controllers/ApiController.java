package ru.ifmo.alekseyivashin.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ifmo.alekseyivashin.dto.CourseDTO;
import ru.ifmo.alekseyivashin.dto.UserCourseDTO;
import ru.ifmo.alekseyivashin.dto.UserDTO;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.models.UserCourse;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserRepository;
import ru.ifmo.alekseyivashin.services.ConverterService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Creator: aleks
 * Date:    08.05.17
 */

@Controller
@RequestMapping("/api")
public class ApiController {


    private final ConverterService converterService;
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public ApiController(ConverterService converterService, UserRepository userRepository, UserCourseRepository userCourseRepository, CourseRepository courseRepository) {
        this.converterService = converterService;
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
        this.courseRepository = courseRepository;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    List<UserDTO> getAllUsers() throws JsonProcessingException {
        List<User> users = (List<User>) userRepository.findAll();
        List<UserDTO> userDTOs = users.stream().map(converterService::userToDTO).collect(Collectors.toList());

        List<Course> courses = (List<Course>) courseRepository.findAll();
        List<CourseDTO> courseDTOs = courses.stream().map(converterService::courseToDTO).collect(Collectors.toList());

        List<UserCourse> userCourses = (List<UserCourse>) userCourseRepository.findAll();
        List<UserCourseDTO> userCourseDTOs = userCourses.stream().map(converterService::userCourseToDTO).collect(Collectors.toList());

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        rootNode.putArray("users").addAll((ArrayNode) mapper.valueToTree(users));

        System.out.println(mapper.writeValueAsString(rootNode));

        return null;
    }
}
