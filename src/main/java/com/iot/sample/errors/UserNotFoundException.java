package com.iot.sample.errors;


public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String error) {
        super(error);
    }
}
