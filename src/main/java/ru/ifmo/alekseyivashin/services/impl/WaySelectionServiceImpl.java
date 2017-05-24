package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.TestRepository;
import ru.ifmo.alekseyivashin.services.CourseService;
import ru.ifmo.alekseyivashin.services.TestService;
import ru.ifmo.alekseyivashin.services.WaySelectionService;

import java.util.Comparator;

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
        if (testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.START, null) == null) {
            return "redirect:/course/{courseId}/test?type=start&lectureId=null";
        }
        Lecture lecture = selectLecture(userCourse);
        if (testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.MEDIUM, lecture) != null) {
            return "redirect:/course/{courseId}/test?type=medium&lectureId=" + lecture.getId();
        }
        return "redirect:/course/{courseId}/lecture/" + lecture.getId();
    }

    @Override
    public Test selectTest(UserCourse userCourse, String type, Lecture lecture) {
        switch (type) {
            case "start":
                if (testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.START, null) == null) {
                    testService.createStartTest(userCourse);
                }
                return testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.START, null);
            case "medium":
                if (testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.MEDIUM, lecture) == null) {
                    testService.createMediumTest(userCourse, lecture);
                }
                return testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.MEDIUM, lecture);
        }
        return null;
    }

    private Lecture selectLecture(UserCourse userCourse) {
        // выбор темы с самым минимальным уровнем знаний
        UserTheme userTheme = userCourse.getUserThemes().stream()
                .min(Comparator.comparingDouble(UserTheme::getUserLevel)).get();
        Double userLevel = userTheme.getUserLevel();
        return userTheme.getTheme().getLectures().stream()
                .min(Comparator.comparingDouble(lecture -> Math.abs(lecture.getLevel() - userLevel))).get();

    }
}
