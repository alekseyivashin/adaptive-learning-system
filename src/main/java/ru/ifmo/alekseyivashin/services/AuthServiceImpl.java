package ru.ifmo.alekseyivashin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.UserRepository;

/**
 * Created on : 20.04.2017
 * Author     : aliv0816
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void signUp(User user) {
    if (userRepository.findUserByName(user.getName()))
    }

    @Override
    public void signIn(User user) {

    }

    @Override
    public void signOut(User user) {

    }
}
