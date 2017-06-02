package ru.ifmo.alekseyivashin.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.dto.CourseDTO;
import ru.ifmo.alekseyivashin.dto.KeywordDTO;
import ru.ifmo.alekseyivashin.dto.UserCourseParentDTO;
import ru.ifmo.alekseyivashin.dto.UserDTO;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.Keyword;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.KeywordRepository;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserRepository;
import ru.ifmo.alekseyivashin.services.ApiService;
import ru.ifmo.alekseyivashin.services.ConverterService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Creator: aleks
 * Date:    26.05.17
 */

@Component
public class ApiServiceImpl implements ApiService {

    private final ConverterService converterService;
    private final UserRepository userRepository;
    private final UserCourseRepository userCourseRepository;
    private final CourseRepository courseRepository;
    private final KeywordRepository keywordRepository;


    @Autowired
    public ApiServiceImpl(ConverterService converterService, UserRepository userRepository, UserCourseRepository userCourseRepository, CourseRepository courseRepository, KeywordRepository keywordRepository) {
        this.converterService = converterService;
        this.userRepository = userRepository;
        this.userCourseRepository = userCourseRepository;
        this.courseRepository = courseRepository;
        this.keywordRepository = keywordRepository;
    }

    @Override
    public String getJsonData(Integer userId) throws JsonProcessingException {
        List<Keyword> keywords = (List<Keyword>) keywordRepository.findAll();
        List<KeywordDTO> keywordDTOs = keywords.stream().map(converterService::keywordToDTO).collect(Collectors.toList());Collectors.toList();

        List<User> users = (List<User>) userRepository.findAll();
        List<UserDTO> userDTOs = users.stream().map(converterService::userToDTO).collect(Collectors.toList());

        List<Course> courses = (List<Course>) courseRepository.findAll();
        List<CourseDTO> courseDTOs = courses.stream().map(converterService::courseToDTO).collect(Collectors.toList());

        List<UserCourseParentDTO> userCourseDTOs = users.stream().map(converterService::userCourseToDTO).collect(Collectors.toList());

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        if (userId != null) {
            rootNode.put("userId", userId);
        }
        rootNode.putArray("keywords").addAll((ArrayNode) mapper.valueToTree(keywordDTOs));
        rootNode.putArray("users").addAll((ArrayNode) mapper.valueToTree(userDTOs));
        rootNode.putArray("courses").addAll((ArrayNode) mapper.valueToTree(courseDTOs));
        rootNode.putArray("userCourses").addAll((ArrayNode) mapper.valueToTree(userCourseDTOs));

        return mapper.writeValueAsString(rootNode);
    }
}
