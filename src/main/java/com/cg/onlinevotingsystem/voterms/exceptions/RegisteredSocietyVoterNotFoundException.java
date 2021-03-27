package com.cg.onlinevotingsystem.voterms.exceptions;

public class RegisteredSocietyVoterNotFoundException extends RuntimeException{
    public RegisteredSocietyVoterNotFoundException() {
        super("Voter not found in DB");
    }

    public RegisteredSocietyVoterNotFoundException(String message) {
        super(message);
    }
}
