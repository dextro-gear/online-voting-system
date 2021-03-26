package com.cg.onlinevotingsystem.nominatedcandidatems.entities;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NominatedCandidates{

    @Id
    @GeneratedValue
    private int candidateID;

    private String nominationFormNo;

    @OneToOne
    RegisteredSocietyVoters societyVoter;


    public NominatedCandidates() {
    }

    public NominatedCandidates(String nominationFormNo, RegisteredSocietyVoters voter) {
        this.nominationFormNo = nominationFormNo;
        this.societyVoter = voter;
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

    public RegisteredSocietyVoters getSocietyVoter() {
        return societyVoter;
    }

    public void setSocietyVoter(RegisteredSocietyVoters societyVoter) {
        this.societyVoter = societyVoter;
    }
}
