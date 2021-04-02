package com.cg.onlinevotingsystem.voterms.exceptions;

public class VoterNotFoundException extends RuntimeException {
    public VoterNotFoundException(String msg) {
        super(msg);
    }
}
