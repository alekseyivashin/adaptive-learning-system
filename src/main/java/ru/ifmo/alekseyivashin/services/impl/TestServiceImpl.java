package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.TestRepository;
import ru.ifmo.alekseyivashin.services.TestService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Component
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void createStartTest(UserCourse userCourse) {
        Test test = new Test();
        test.setType(TestType.START);
        test.setUserCourse(userCourse);

        List<Question> questions = new ArrayList<>();
        userCourse.getCourse().getThemes().forEach(theme -> {
            Question question = theme.getLectures().stream()
                    .min(Comparator.comparingInt(Lecture::getLevel)).get()
                    .getQuestions().stream()
                    .min(Comparator.comparingInt(Question::getLevel)).get();
            questions.add(question);
        });

        test.setQuestions(questions);
        testRepository.save(test);
    }
}
