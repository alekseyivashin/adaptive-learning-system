package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Lecture;
import ru.ifmo.alekseyivashin.models.Test;
import ru.ifmo.alekseyivashin.models.TestType;
import ru.ifmo.alekseyivashin.models.UserCourse;

/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Service
public interface TestService {
    void createStartTest(UserCourse userCourse);
    void createMediumTest(UserCourse userCourse, Lecture lecture);
    void checkTest(UserCourse userCourse, Test userTest);
}
