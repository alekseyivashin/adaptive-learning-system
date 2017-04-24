package ru.ifmo.alekseyivashin.services;

import org.springframework.stereotype.Service;
import ru.ifmo.alekseyivashin.messages.Message;

/**
 * Created on : 20.04.2017
 * Author     : aleksey
 */

@Service
public interface AuthService {

    public Message signUp(String name, String password);
    public Message signIn(String name, String password);
}
