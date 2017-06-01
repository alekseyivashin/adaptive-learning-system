package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.TestRepository;
import ru.ifmo.alekseyivashin.repositories.UserThemeRepository;
import ru.ifmo.alekseyivashin.services.TestService;
import ru.ifmo.alekseyivashin.services.WaySelectionService;
import ru.ifmo.alekseyivashin.utils.Constants;

import java.util.Comparator;

/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Component
public class WaySelectionServiceImpl implements WaySelectionService {

    private final TestService testService;
    private final TestRepository testRepository;
    private final UserThemeRepository userThemeRepository;


    @Autowired
    public WaySelectionServiceImpl(TestService testService, TestRepository testRepository, UserThemeRepository userThemeRepository) {
        this.testService = testService;
        this.testRepository = testRepository;
        this.userThemeRepository = userThemeRepository;
    }

    @Override
    public String selectWay(UserCourse userCourse) {
        if (userCourse.getCourse().getThemes().size() == 0) {
            return "redirect:/course/{courseId}/final";
        }
        if (testRepository.findByUserCourseAndTypeAndLecture(userCourse, TestType.START, null) == null) {
            return "redirect:/course/{courseId}/test?type=start&lectureId=null";
        }
        if (isLearningGoalAchieved(userCourse)) {
            return "redirect:/course/{courseId}/final";
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
        userTheme.setCount(userTheme.getCount() + 1);
        userThemeRepository.save(userTheme);
        Double userLevel = userTheme.getUserLevel();
        return userTheme.getTheme().getLectures().stream()
                .min(Comparator.comparingDouble(lecture -> Math.abs(lecture.getLevel() - userLevel))).get();

    }

    private boolean isLearningGoalAchieved(UserCourse userCourse) {
        return userThemeRepository.findAllByUserCourse(userCourse).stream()
                .allMatch(userTheme -> userTheme.getUserLevel() > Constants.BORDER_SCORE);
    }
}
