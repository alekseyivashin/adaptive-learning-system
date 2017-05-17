package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.*;

/**
 * Creator: aleks
 * Date:    17.05.17
 */

@Service
public interface CourseService {
    void createAndSaveUserCourseObject(User user, Course course);
    Test getTestByType(Course course, TestType testType);
}
