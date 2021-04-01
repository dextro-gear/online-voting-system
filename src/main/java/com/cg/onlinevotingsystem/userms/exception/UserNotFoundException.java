package com.cg.onlinevotingsystem.userms.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found in the DB");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
