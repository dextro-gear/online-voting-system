package com.cg.onlinevotingsystem.cooperativesocietyms.exceptions;

public class InvalidSocietyException extends RuntimeException{
    public InvalidSocietyException() {
        super("Society cannot be null");
    }

    public InvalidSocietyException(String message) {
        super(message);
    }
}
