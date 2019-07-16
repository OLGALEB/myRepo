package com.playtika;

public class UserWrongPriceAmountException extends RuntimeException {
    public UserWrongPriceAmountException(String message) {
        super(message);
    }
}