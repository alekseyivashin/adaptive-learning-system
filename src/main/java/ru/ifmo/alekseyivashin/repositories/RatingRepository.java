package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ifmo.alekseyivashin.models.Rating;

/**
 * Created on : 01.06.2017
 * Author     : aliv0816
 */

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
