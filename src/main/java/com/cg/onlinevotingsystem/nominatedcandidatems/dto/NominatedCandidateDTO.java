package com.cg.onlinevotingsystem.nominatedcandidatems.dto;

import com.cg.onlinevotingsystem.voterms.dto.VoterDetails;

public class NominatedCandidateDTO {

    private int candidateID;
    private String nominationFormNo;
    private VoterDetails voterDetails;

    public NominatedCandidateDTO(int candidateID, String nominationFormNo, VoterDetails voterDetails) {
        this.candidateID = candidateID;
        this.nominationFormNo = nominationFormNo;
        this.voterDetails=voterDetails;
    }

    public VoterDetails getVoterDetails() {
        return voterDetails;
    }

    public void setVoterDetails(VoterDetails voterDetails) {
        this.voterDetails = voterDetails;
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

}
