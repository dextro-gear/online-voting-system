package com.cg.onlinevotingsystem.cooperativesocietyms.exceptions;

public class SocietyNotFoundException extends RuntimeException{

    public SocietyNotFoundException(){
        super("Cooperative Society Not Found in DB");
    }
    public SocietyNotFoundException(String message) {
        super(message);
    }

}
