package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.dto.*;
import ru.ifmo.alekseyivashin.models.*;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

@Service
public interface ConverterService {
    UserDTO userToDTO(User user);

    CourseDTO courseToDTO(Course course);

    UserCourseParentDTO userCourseToDTO(User user);

    KeywordDTO keywordToDTO(Keyword keyword);

    RecommendationDTO recommendationToDTO(Recommendation recommendation);
}
