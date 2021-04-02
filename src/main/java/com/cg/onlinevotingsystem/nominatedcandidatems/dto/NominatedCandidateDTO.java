package com.cg.onlinevotingsystem.nominatedcandidatems.dto;

import com.cg.onlinevotingsystem.voterms.dto.UpdateVoterRequest;

public class NominatedCandidateDTO {

    private int candidateID;
    private String nominationFormNo;
    private UpdateVoterRequest voter;

    public NominatedCandidateDTO(int candidateID, String nominationFormNo, UpdateVoterRequest voter) {
        this.candidateID = candidateID;
        this.nominationFormNo = nominationFormNo;
        this.voter = voter;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getNominationFormNo() {
        return nominationFormNo;
    }

    public void setNominationFormNo(String nominationFormNo) {
        this.nominationFormNo = nominationFormNo;
    }

    public UpdateVoterRequest getVoter() {
        return voter;
    }

    public void setVoter(UpdateVoterRequest voter) {
        this.voter = voter;
    }
}
