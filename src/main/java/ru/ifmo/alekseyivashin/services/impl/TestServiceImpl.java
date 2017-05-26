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
                testRepository.delete(correctTest);
        }
        setProgress(userCourse);
    }

    private void checkStartTest(UserCourse userCourse, Test userTest, Test correctTest) {
        double allQuestionsScore = updateUserLevels(userCourse, userTest, correctTest);
        userCourse.setStartScore((allQuestionsScore / correctTest.getQuestions().size()) * 100);
        userCourseRepository.save(userCourse);
    }

    private void checkMediumTest(UserCourse userCourse, Test userTest, Test correctTest) {
        updateUserLevels(userCourse, userTest, correctTest);
    }

    private double updateUserLevels(UserCourse userCourse, Test userTest, Test correctTest) {
        double allQuestionsScore = 0;
        for (int i = 0; i < correctTest.getQuestions().size(); i++) {
            Question correctQuestion = correctTest.getQuestions().get(i);
            Question userQuestion = userTest.getQuestions().get(i);
            double score = getQuestionScore(userQuestion, correctQuestion);

            UserTheme userTheme = userThemeRepository.findByUserCourseAndTheme(userCourse, correctQuestion.getLecture().getTheme());

            double E = 1 / (1 + Math.pow(10, (correctQuestion.getLevel() - userTheme.getUserLevel()) / 400));
            double newLevel = userTheme.getUserLevel() + Constants.K * (score - E);

            userTheme.setUserLevel(newLevel);
            userThemeRepository.save(userTheme);

            allQuestionsScore += score;
        }
        return allQuestionsScore;
    }

    private double getQuestionScore(Question userQuestion, Question correctQuestion) {
        int correctAnswerCount = (int) correctQuestion.getAnswers().stream()
                .filter(answer -> answer.getCorrect().equals(true))
                .count();
        double score = 0;
        for (int i = 0; i < correctQuestion.getAnswers().size(); i++) {
            Answer correctAnswer = correctQuestion.getAnswers().get(i);
            Answer userAnswer = userQuestion.getAnswers().get(i);
            if (userAnswer.getCorrect().equals(true) && correctAnswer.getCorrect().equals(true)) score++;
            if (userAnswer.getCorrect().equals(true) && correctAnswer.getCorrect().equals(false)) score--;
        }
        if (score < 0) score = 0;
        return score / correctAnswerCount;
    }

    private void setProgress(UserCourse userCourse) {
        List<UserTheme> userThemes = userThemeRepository.findAllByUserCourse(userCourse);
        int completeThemesCount = (int) userThemes.stream().mapToDouble(UserTheme::getUserLevel).filter(v -> v > Constants.BORDER_SCORE).count();
        userCourse.setProgress((double) completeThemesCount / userThemes.size());
        userCourseRepository.save(userCourse);
    }
}
