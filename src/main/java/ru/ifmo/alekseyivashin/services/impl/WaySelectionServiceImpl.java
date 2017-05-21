package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.models.Test;
import ru.ifmo.alekseyivashin.models.TestType;
import ru.ifmo.alekseyivashin.models.UserCourse;
import ru.ifmo.alekseyivashin.repositories.TestRepository;
import ru.ifmo.alekseyivashin.services.CourseService;
import ru.ifmo.alekseyivashin.services.TestService;
import ru.ifmo.alekseyivashin.services.WaySelectionService;

/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Component
public class WaySelectionServiceImpl implements WaySelectionService {

    private final TestService testService;
    private final CourseService courseService;
    private final TestRepository testRepository;


    @Autowired
    public WaySelectionServiceImpl(TestService testService, CourseService courseService, TestRepository testRepository) {
        this.testService = testService;
        this.courseService = courseService;
        this.testRepository = testRepository;
    }

    @Override
    public String selectWay(UserCourse userCourse) {
        if (testRepository.findByUserCourseAndType(userCourse, TestType.START) == null) {
            testService.createStartTest(userCourse);
        }
        return "redirect:/course/{courseId}/test?type=start";
    }

    @Override
    public Test selectTest(UserCourse userCourse, String type) {
        switch (type) {
            case "start":
                return testRepository.findByUserCourseAndType(userCourse, TestType.START);
        }
        return null;
    }
}
