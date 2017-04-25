package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.messages.Message;
import ru.ifmo.alekseyivashin.models.User;

/**
 * Created on : 20.04.2017
 * Author     : aleksey
 */

@Service
public interface AuthService {

    public Message signUp(User user);
    public Message signIn(User user);
}
