package com.cg.onlinevotingsystem.electionoffice.exceptions;

public class ElectionOfficerNotFoundException extends RuntimeException{
    public ElectionOfficerNotFoundException() {
        super("Election Officer was not found in the DB");
    }

    public ElectionOfficerNotFoundException(String message) {
        super(message);
    }
}
