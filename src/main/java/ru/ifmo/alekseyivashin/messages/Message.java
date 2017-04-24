package ru.ifmo.alekseyivashin.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on : 24.04.2017
 * Author     : aliv0816
 */

@Data
@AllArgsConstructor
public class Message {
    private Status status;
    private String message;

    public enum Status {
        ERROR,
        SUCCESS
    }
}
