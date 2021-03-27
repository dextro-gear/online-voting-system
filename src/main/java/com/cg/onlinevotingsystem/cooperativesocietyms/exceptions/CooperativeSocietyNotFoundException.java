package com.cg.onlinevotingsystem.cooperativesocietyms.exceptions;

public class CooperativeSocietyNotFoundException extends RuntimeException{
    public CooperativeSocietyNotFoundException() {
        super("Society not found");
    }

    public CooperativeSocietyNotFoundException(String message) {
        super(message);
    }
}
