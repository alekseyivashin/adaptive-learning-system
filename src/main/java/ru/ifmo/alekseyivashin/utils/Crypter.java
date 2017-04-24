package ru.ifmo.alekseyivashin.utils;

import org.springframework.stereotype.Service;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

@Service
public interface Crypter {
    public String encrypt(String unencryptedPassword);
    public String decrypt(String encryptedPassword);
}
