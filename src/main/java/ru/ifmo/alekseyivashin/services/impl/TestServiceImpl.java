package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.models.*;
import ru.ifmo.alekseyivashin.repositories.TestRepository;
import ru.ifmo.alekseyivashin.repositories.UserCourseRepository;
import ru.ifmo.alekseyivashin.repositories.UserThemeRepository;
import ru.ifmo.alekseyivashin.services.TestService;
import ru.ifmo.alekseyivashin.utils.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Component
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final UserThemeRepository userThemeRepository;
    private final UserCourseRepository userCourseRepository;


    @Autowired
    public TestServiceImpl(TestRepository testRepository, UserThemeRepository userThemeRepository, UserCourseRepository userCourseRepository) {
        this.testRepository = testRepository;
        this.userThemeRepository = userThemeRepository;
        this.userCourseRepository = userCourseRepository;
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

    @Override
    public void createMediumTest(UserCourse userCourse, Lecture lecture) {
        Test test = new Test();
        test.setType(TestType.MEDIUM);
        test.setLecture(lecture);
        test.setUserCourse(userCourse);
        List<Question> questions = new ArrayList<>(lecture.getQuestions());
        test.setQuestions(questions);
        testRepository.save(test);
    }

    @Override
    public void checkTest(UserCourse userCourse, Test userTest) {
        Test correctTest = testRepository.findByUserCourseAndTypeAndLecture(userCourse, userTest.getType(), userTest.getLecture());
        switch (userTest.getType()) {
            case START:
                checkStartTest(userCourse, userTest, correctTest);
                break;
            case MEDIUM:
                checkMediumTest(userCourse, userTest, correctTest);
        }
    }

    private void checkStartTest(UserCourse userCourse, Test userTest, Test correctTest) {
        double allQuestionsScore = 0;
        for (int i = 0; i < correctTest.getQuestions().size(); i++) {
            Question question = correctTest.getQuestions().get(i);
            int correctAnswers = getCorrectAnswers(question, userTest, i);

            UserTheme userTheme = userThemeRepository.findByUserCourseAndTheme(userCourse, question.getLecture().getTheme());

            double E = 1 / (1 + Math.pow(10, (question.getLevel() - userTheme.getUserLevel()) / 400));
            double questionScore = (double) correctAnswers / question.getAnswers().size();
            double newLevel = userTheme.getUserLevel() + Constants.K * (questionScore - E);

            userTheme.setUserLevel(newLevel);
            userThemeRepository.save(userTheme);

            allQuestionsScore += questionScore;
        }
        userCourse.setStartScore((allQuestionsScore / correctTest.getQuestions().size()) * 100);
        userCourseRepository.save(userCourse);
    }

    private void checkMediumTest(UserCourse userCourse, Test userTest, Test correctTest) {
        for (int i = 0; i < correctTest.getQuestions().size(); i++) {
            Question question = correctTest.getQuestions().get(i);
            int correctAnswers = getCorrectAnswers(question, userTest, i);

            UserTheme userTheme = userThemeRepository.findByUserCourseAndTheme(userCourse, question.getLecture().getTheme());

            double E = 1 / (1 + Math.pow(10, (question.getLevel() - userTheme.getUserLevel()) / 400));
            double questionScore = (double) correctAnswers / question.getAnswers().size();
            double newLevel = userTheme.getUserLevel() + Constants.K * (questionScore - E);

            userTheme.setUserLevel(newLevel);
            userThemeRepository.save(userTheme);
        }
    }

    private int getCorrectAnswers(Question question, Test userTest, int questionIndex) {
        int correctAnswers = 0;
        for (int j = 0; j < question.getAnswers().size(); j++) {
            Answer correctAnswer = question.getAnswers().get(j);
            Answer userAnswer = userTest.getQuestions().get(questionIndex).getAnswers().get(j);
            if (correctAnswer.getCorrect().equals(userAnswer.getCorrect())) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }
}
