package ru.ifmo.alekseyivashin.messages;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

public class Message {
    private Status status;
    private String message;

    public Message(Status status, String message) {
        this.status = status;
        this.message = message;
    }

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
