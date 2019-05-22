package com.ostanin.exception;

public class PasswordNotMatchException extends NotFoundException{
    public PasswordNotMatchException(String message) {
        super(message);
    }
}
