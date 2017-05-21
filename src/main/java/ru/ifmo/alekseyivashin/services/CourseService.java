package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;

/**
 * Creator: aleks
 * Date:    17.05.17
 */

@Service
public interface CourseService {
    void createAndSaveUserCourseObject(User user, Course course);
}
