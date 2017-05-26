package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.alekseyivashin.models.Theme;
import ru.ifmo.alekseyivashin.models.UserCourse;
import ru.ifmo.alekseyivashin.models.UserTheme;

import java.util.List;

/**
 * Creator: aleks
 * Date:    24.05.17
 */
@Repository
public interface UserThemeRepository extends CrudRepository<UserTheme, Integer> {
    UserTheme findByUserCourseAndTheme(UserCourse userCourse, Theme theme);
    List<UserTheme> findAllByUserCourse(UserCourse userCourse);
}
