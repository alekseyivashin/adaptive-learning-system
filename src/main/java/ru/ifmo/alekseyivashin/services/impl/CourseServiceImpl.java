package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.models.UserCourse;
import ru.ifmo.alekseyivashin.models.UserTheme;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserThemeRepository;
import ru.ifmo.alekseyivashin.services.CourseService;
import ru.ifmo.alekseyivashin.utils.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Creator: aleks
 * Date:    17.05.17
 */
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserCourseRepository userCourseRepository;
    private final UserThemeRepository userThemeRepository;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, UserCourseRepository userCourseRepository, UserThemeRepository userThemeRepository) {
        this.courseRepository = courseRepository;
        this.userCourseRepository = userCourseRepository;
        this.userThemeRepository = userThemeRepository;
    }

    @Override
    public void createAndSaveUserCourseObject(User user, Course course) {

        course.setUserCount(course.getUserCount() + 1);
        courseRepository.save(course);

        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        userCourse.setStartDate(new Date());
        userCourse.setProgress((double) 0);
        userCourseRepository.save(userCourse);

        course.getThemes().forEach(theme -> {
            UserTheme userTheme = new UserTheme();
            userTheme.setTheme(theme);
            userTheme.setUserCourse(userCourse);
            userTheme.setUserLevel((double) Constants.START_SCORE);
            userThemeRepository.save(userTheme);
        });

    }
}
