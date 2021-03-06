package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.models.UserCourse;

import java.util.List;

/**
 * Creator: aleks
 * Date:    08.05.17
 */

@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, Integer> {

    UserCourse findByUserAndCourse(User user, Course course);

    List<UserCourse> findAllByUser(User user);

    @Query(nativeQuery = true,
            value = "SELECT *\n" +
                    "FROM users_courses\n" +
                    "WHERE user_id = :id")
    List<UserCourse> getUserCoursesByUserId(@Param("id") int userId);

    @Query(nativeQuery = true,
            value = "SELECT *\n" +
                    "FROM users_courses\n" +
                    "WHERE user_id = ?1\n" +
                    "AND progress <> 1")
    List<UserCourse> getUserCoursesInProgress(int userId);

    @Query(nativeQuery = true,
            value = "SELECT *\n" +
                    "FROM users_courses\n" +
                    "WHERE user_id = ?1\n" +
                    "AND progress = 1")
    List<UserCourse> getFinishedUserCourses(int userId);
}
