package com.cg.onlinevotingsystem.votedlistms.exceptions;

public class VoteNotFoundException extends RuntimeException{
    public VoteNotFoundException() {
        super("VotedList not found in the DB");
    }

    public VoteNotFoundException(String message) {
        super(message);
    }
}
