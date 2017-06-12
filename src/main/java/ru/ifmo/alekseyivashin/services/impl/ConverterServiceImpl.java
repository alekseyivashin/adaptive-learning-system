package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.dto.*;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.services.ConverterService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

@Component
public class ConverterServiceImpl implements ConverterService {

    private final UserCourseRepository userCourseRepository;

    @Autowired
    public ConverterServiceImpl(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setKeywords(user.getKeywords());
        return userDTO;
    }

    @Override
    public CourseDTO courseToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setRating(course.getRating());
        courseDTO.setUserCount(course.getUserCount());
        courseDTO.setKeywords(course.getKeywords());
        return courseDTO;
    }

    @Override
    public UserCourseParentDTO userCourseToDTO(User user) {
        UserCourseParentDTO dto = new UserCourseParentDTO();
        dto.setUserId(user.getId());
        List<UserCourseDTO> courseDTOs = new ArrayList<>();
        userCourseRepository.findAllByUser(user).forEach(userCourse -> {
            UserCourseDTO userCourseDTO = new UserCourseDTO();
            userCourseDTO.setCourseId(userCourse.getCourse().getId());
            userCourseDTO.setStartDate(userCourse.getStartDate());
            userCourseDTO.setEndDate(userCourse.getEndDate());
            userCourseDTO.setStartScore(userCourse.getStartScore());
            userCourseDTO.setEndScore(userCourse.getEndScore());
            userCourseDTO.setRating(userCourse.getRating());
            userCourseDTO.setProgress(userCourse.getProgress());
            courseDTOs.add(userCourseDTO);
        });
        dto.setCourses(courseDTOs);
        return dto;
    }

    @Override
    public KeywordDTO keywordToDTO(Keyword keyword) {
        KeywordDTO keywordDTO = new KeywordDTO();
        keywordDTO.setId(keyword.getId());
        keywordDTO.setName(keyword.getName());
        return keywordDTO;
    }

    @Override
    public RecommendationDTO recommendationToDTO(Recommendation recommendation) {
        RecommendationDTO recommendationDTO = new RecommendationDTO();
        recommendationDTO.setUserId(recommendation.getUser().getId());
        recommendationDTO.setCourseId(recommendation.getCourse().getId());
        recommendationDTO.setRating(recommendation.getRating());
        return recommendationDTO;
    }
}
