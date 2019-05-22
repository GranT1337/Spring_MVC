package com.ostanin.exception;

public class SuchUserAlreadyRegisteredException extends NotFoundException {

    public SuchUserAlreadyRegisteredException(String message) {
        super(message);
    }

}
