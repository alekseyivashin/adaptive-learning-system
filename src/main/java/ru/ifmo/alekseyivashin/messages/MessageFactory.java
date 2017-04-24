package ru.ifmo.alekseyivashin.messages;

import org.springframework.stereotype.Service;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

@Service
public interface MessageFactory {
    public Message getErrorMessage(String message);
    public Message getSuccessMessage(String message);
    public Message getSuccessMessage();
}
