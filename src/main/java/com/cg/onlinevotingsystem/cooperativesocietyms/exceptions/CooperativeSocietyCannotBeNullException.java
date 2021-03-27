package com.cg.onlinevotingsystem.cooperativesocietyms.exceptions;

public class CooperativeSocietyCannotBeNullException extends RuntimeException{
    public CooperativeSocietyCannotBeNullException() {
        super("Society cannot be null");
    }

    public CooperativeSocietyCannotBeNullException(String message) {
        super(message);
    }
}
