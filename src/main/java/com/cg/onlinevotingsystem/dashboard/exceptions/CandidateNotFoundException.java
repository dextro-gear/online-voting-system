package com.cg.onlinevotingsystem.dashboard.exceptions;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException() {
        super("Candidate not found");
    }

    public CandidateNotFoundException(String message) {
        super(message);
    }
}
