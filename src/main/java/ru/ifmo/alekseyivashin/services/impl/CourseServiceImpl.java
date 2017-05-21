package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.models.UserCourse;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.services.CourseService;

import java.util.Date;

/**
 * Creator: aleks
 * Date:    17.05.17
 */
@Service
public class CourseServiceImpl implements CourseService {

    private final UserCourseRepository userCourseRepository;

    @Autowired
    public CourseServiceImpl(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    @Override
    public void createAndSaveUserCourseObject(User user, Course course) {
        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        userCourse.setStartDate(new Date());
        userCourse.setProgress(0f);
        userCourseRepository.save(userCourse);
    }
}
