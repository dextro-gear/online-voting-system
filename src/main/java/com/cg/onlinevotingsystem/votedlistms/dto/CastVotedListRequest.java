package com.cg.onlinevotingsystem.votedlistms.dto;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CastVotedListRequest {
    @NotBlank
    @Length(min=10,max=10)
    private String voterCardID;

    @Min(1)
    private int candidateID;

    @Min(1)
    private int societyID;


    public String getVoterCardID() {
        return voterCardID;
    }

    public void setVoterCardID(String voterCardID) {
        this.voterCardID = voterCardID;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public int getSocietyID() {
        return societyID;
    }

    public void setSocietyID(int societyID) {
        this.societyID = societyID;
    }
}
