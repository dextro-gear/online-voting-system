package com.cg.onlinevotingsystem.nominatedcandidatems.entities;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class NominatedCandidates{

    @Id
    @GeneratedValue
    private int candidateID;

    String nominationFormNo;

//    RegisteredSocietyVoters societyVoter;


    public NominatedCandidates(String nominationFormNo) {
        this.nominationFormNo = nominationFormNo;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public String getNominationFormNo() {
        return nominationFormNo;
    }

    public void setNominationFormNo(String nominationFormNo) {
        this.nominationFormNo = nominationFormNo;
    }
}
