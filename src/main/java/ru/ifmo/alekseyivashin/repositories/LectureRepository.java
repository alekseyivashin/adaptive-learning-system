package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Lecture;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Service
public interface LectureRepository extends CrudRepository<Lecture, Integer> {
}
