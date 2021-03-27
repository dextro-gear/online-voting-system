package com.cg.onlinevotingsystem.voterms.exceptions;

public class VoterNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public VoterNotFoundException(String msg) {
		super(msg);
	}
}
