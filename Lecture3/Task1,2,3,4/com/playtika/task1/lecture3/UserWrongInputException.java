package com.playtika.task1.lecture3;

import java.util.InputMismatchException;

public class UserWrongInputException extends InputMismatchException {

    public UserWrongInputException(String message) {
        super(message);
    }
}