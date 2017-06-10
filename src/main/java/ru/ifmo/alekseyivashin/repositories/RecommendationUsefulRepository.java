package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.alekseyivashin.models.RecommendationUseful;
import ru.ifmo.alekseyivashin.models.User;

/**
 * Creator: aleks
 * Date:    10.06.17
 */
public interface RecommendationUsefulRepository extends CrudRepository<RecommendationUseful, Integer> {
    RecommendationUseful findByUser(User user);
}
