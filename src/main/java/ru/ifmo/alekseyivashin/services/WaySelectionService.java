package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Lecture;
import ru.ifmo.alekseyivashin.models.Test;
import ru.ifmo.alekseyivashin.models.UserCourse;

/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Service
public interface WaySelectionService {
    String selectWay(UserCourse userCourse);
    Test selectTest(UserCourse userCourse, String type, Lecture lecture);
}
