package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Course;

import java.util.List;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Service
public interface CourseRepository extends CrudRepository<Course, Integer> {

}

