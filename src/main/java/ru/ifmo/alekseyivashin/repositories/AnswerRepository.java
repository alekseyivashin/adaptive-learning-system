package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.alekseyivashin.models.Answer;

/**
 * Creator: aleks
 * Date:    14.05.17
 */

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}
