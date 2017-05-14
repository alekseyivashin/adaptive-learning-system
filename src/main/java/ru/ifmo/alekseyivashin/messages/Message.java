package ru.ifmo.alekseyivashin.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

@AllArgsConstructor
public class Message {
    private Status status;
    private String message;

    public enum Status {
        ERROR,
        SUCCESS
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
