package com.cg.onlinevotingsystem.cooperativesocietyms.exceptions;

public class CooperativeSocietyNotFoundException extends RuntimeException{
    public CooperativeSocietyNotFoundException(){super("Cooperative Society Not Found in DB");}
    public CooperativeSocietyNotFoundException(String message){super(message);}
}
