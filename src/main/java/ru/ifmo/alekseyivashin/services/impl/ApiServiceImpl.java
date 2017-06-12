package ru.ifmo.alekseyivashin.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.dto.*;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.Keyword;
import ru.ifmo.alekseyivashin.models.Recommendation;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.*;
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
    private final CourseRepository courseRepository;
    private final KeywordRepository keywordRepository;
    private final RecommendationRepository recommendationRepository;


    @Autowired
    public ApiServiceImpl(ConverterService converterService, UserRepository userRepository, CourseRepository courseRepository, KeywordRepository keywordRepository, RecommendationRepository recommendationRepository) {
        this.converterService = converterService;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.keywordRepository = keywordRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public String getJsonData(Integer userId) throws JsonProcessingException {
        List<Recommendation> recommendations = (List<Recommendation>) recommendationRepository.findAll();
        List<RecommendationDTO> recommendationDTOs = recommendations.stream().map(converterService::recommendationToDTO).collect(Collectors.toList());

        List<Keyword> keywords = (List<Keyword>) keywordRepository.findAll();
        List<KeywordDTO> keywordDTOs = keywords.stream().map(converterService::keywordToDTO).collect(Collectors.toList());

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
        rootNode.putArray("recommendations").addAll((ArrayNode) mapper.valueToTree(recommendationDTOs));

        return mapper.writeValueAsString(rootNode);
    }
}
