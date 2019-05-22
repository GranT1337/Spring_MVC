package com.ostanin.exception;

public class NoSuchUserException extends NotFoundException{
    public NoSuchUserException(String message) {
        super(message);
    }
}
