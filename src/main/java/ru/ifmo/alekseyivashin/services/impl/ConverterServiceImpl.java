package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.dto.CourseDTO;
import ru.ifmo.alekseyivashin.dto.UserCourseDTO;
import ru.ifmo.alekseyivashin.dto.UserDTO;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.models.UserCourse;
import ru.ifmo.alekseyivashin.services.ConverterService;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

@Component
public class ConverterServiceImpl implements ConverterService {

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
        courseDTO.setLevel(course.getLevel());
        courseDTO.setRating(course.getRating());
        courseDTO.setUserCount(course.getUserCount());
        courseDTO.setKeywords(course.getKeywords());
        return courseDTO;
    }

    @Override
    public UserCourseDTO userCourseToDTO(UserCourse userCourse) {
        UserCourseDTO userCourseDTO = new UserCourseDTO();
        userCourseDTO.setUserId(userCourse.getUser().getId());
        userCourseDTO.setCourseId(userCourse.getCourse().getId());
        userCourseDTO.setStartDate(userCourse.getStartDate());
        userCourseDTO.setEndDate(userCourse.getEndDate());
        userCourseDTO.setStartScore(userCourse.getStartScore());
        userCourseDTO.setRating(userCourse.getRating());
        userCourseDTO.setProgress(userCourse.getProgress());
        return userCourseDTO;
    }
}
