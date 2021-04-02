package com.cg.onlinevotingsystem.votedlistms.exceptions;

public class InvalidVoteException extends RuntimeException{
    public InvalidVoteException(String msg){
        super(msg);
    }
}
