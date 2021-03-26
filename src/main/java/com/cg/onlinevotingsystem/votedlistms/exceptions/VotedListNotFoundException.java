package com.cg.onlinevotingsystem.votedlistms.exceptions;

public class VotedListNotFoundException extends RuntimeException{
    public VotedListNotFoundException() {
        super("VotedList not found in the DB");
    }

    public VotedListNotFoundException(String message) {
        super(message);
    }
}
