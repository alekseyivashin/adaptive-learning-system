package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.UserCourse;

import java.util.List;

/**
 * Creator: aleks
 * Date:    08.05.17
 */

@Service
public interface UserCourseRepository extends CrudRepository<UserCourse, Integer> {
    @Query(nativeQuery = true,
            value = "SELECT *\n" +
                    "FROM users_courses\n" +
                    "WHERE user_id = :id")
    List<Course> getUserCourses(@Param("id") int userId);

    @Query(nativeQuery = true,
            value = "SELECT *\n" +
                    "FROM users_courses\n" +
                    "WHERE user_id = :id\n" +
                    "AND pass_value <> 1")
    List<Course> getUserCoursesInProgress(@Param("id") int userId);

    @Query(nativeQuery = true,
            value = "SELECT *\n" +
                    "FROM users_courses\n" +
                    "WHERE user_id = :id\n" +
                    "AND pass_value = 1")
    List<Course> getFinishedUserCourses(@Param("id") int userId);
}
