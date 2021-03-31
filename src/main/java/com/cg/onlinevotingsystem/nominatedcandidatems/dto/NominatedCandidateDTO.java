package com.cg.onlinevotingsystem.nominatedcandidatems.dto;

import com.cg.onlinevotingsystem.voterms.dto.VoterDTO;

public class NominatedCandidateDTO {

    private int candidateID;
    private String nominationFormNo;
    private VoterDTO voter;

    public NominatedCandidateDTO(int candidateID, String nominationFormNo, VoterDTO voter) {
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

    public VoterDTO getVoter() {
        return voter;
    }

    public void setVoter(VoterDTO voter) {
        this.voter = voter;
    }
}
