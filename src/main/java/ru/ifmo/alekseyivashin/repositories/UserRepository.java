package ru.ifmo.alekseyivashin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.User;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */

@Service
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByName(String name);
}
