package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.Theme;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Service
public interface ThemeRepository extends CrudRepository<Theme, Integer> {
}
