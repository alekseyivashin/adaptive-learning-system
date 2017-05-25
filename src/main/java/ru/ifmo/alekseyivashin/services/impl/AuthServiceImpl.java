package ru.ifmo.alekseyivashin.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.alekseyivashin.messages.Message;
import ru.ifmo.alekseyivashin.messages.MessageFactory;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.UserRepository;
import ru.ifmo.alekseyivashin.services.AuthService;
import ru.ifmo.alekseyivashin.utils.Crypter;

/**
 * Created on : 20.04.2017
 * Author     : aliv0816
 */

@Component
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final Crypter crypter;
    private final MessageFactory messageFactory;


    @Autowired
    public AuthServiceImpl(UserRepository userRepository, Crypter crypter, MessageFactory messageFactory) {
        this.userRepository = userRepository;
        this.crypter = crypter;
        this.messageFactory = messageFactory;
    }

    @Override
    @Transactional
    public Message signUp(User user) {
        if (userRepository.findUserByName(user.getName()) != null) {
            return messageFactory.getErrorMessage("User with this name already exists");
        } else {
            user.setPassword(crypter.encrypt(user.getPassword()));

            userRepository.save(user);
            return messageFactory.getSuccessMessage();
        }
    }

    @Override
    public Message signIn(User user) {
        user.setPassword(crypter.encrypt(user.getPassword()));

        User existingUser = userRepository.findUserByName(user.getName());
        if (existingUser == null) {
            return messageFactory.getErrorMessage("Name is incorrect");
        } else {
            if (!user.getPassword().equals(existingUser.getPassword())) {
                return messageFactory.getErrorMessage("Password is incorrect");
            } else {
                return messageFactory.getSuccessMessage();
            }
        }
    }

}
