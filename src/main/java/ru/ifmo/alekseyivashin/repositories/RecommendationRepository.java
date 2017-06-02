package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.alekseyivashin.models.Recommendation;

/**
 * Created on : 02.06.2017
 * Author     : aliv0816
 */

public interface RecommendationRepository extends CrudRepository<Recommendation, Integer> {
}
