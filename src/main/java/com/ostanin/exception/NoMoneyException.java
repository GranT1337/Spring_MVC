package com.ostanin.exception;

public class NoMoneyException extends NotFoundException {
    public NoMoneyException(String message) {
        super(message);
    }
}
