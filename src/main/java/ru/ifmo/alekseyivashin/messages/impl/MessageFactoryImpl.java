package ru.ifmo.alekseyivashin.messages.impl;

import org.springframework.stereotype.Component;
import ru.ifmo.alekseyivashin.messages.Message;
import ru.ifmo.alekseyivashin.messages.MessageFactory;

import static ru.ifmo.alekseyivashin.messages.Message.Status.ERROR;
import static ru.ifmo.alekseyivashin.messages.Message.Status.SUCCESS;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

@Component
public class MessageFactoryImpl implements MessageFactory {

    @Override
    public Message getErrorMessage(String message) {
        return new Message(ERROR, message);
    }

    @Override
    public Message getSuccessMessage(String message) {
        return new Message(SUCCESS, message);
    }

    @Override
    public Message getSuccessMessage() {
        return getSuccessMessage("");
    }
}
