package com.cg.onlinevotingsystem.voterms.exceptions;

public class InvalidVoterException extends RuntimeException{
    public InvalidVoterException(){

    }
    public InvalidVoterException(String msg){
        super(msg);
    }

}
