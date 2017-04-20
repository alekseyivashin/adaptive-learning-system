package ru.ifmo.alekseyivashin.services;

import ru.ifmo.alekseyivashin.models.User;

/**
 * Created on : 20.04.2017
 * Author     : aleksey
 */

public interface AuthService {

    public void signUp(User user);
    public void signIn(User user);
    public void signOut(User user);
}
