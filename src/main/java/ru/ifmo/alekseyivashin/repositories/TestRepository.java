package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Test;
import ru.ifmo.alekseyivashin.models.TestType;
import ru.ifmo.alekseyivashin.models.UserCourse;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Service
public interface TestRepository extends CrudRepository<Test, Integer> {

    Test findByUserCourseAndType(UserCourse userCourse, TestType testType);
}
