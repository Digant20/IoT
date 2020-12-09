package com.iot.sample.errors;


public class UserExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserExistsException(String error) {
        super(error);
    }
}
