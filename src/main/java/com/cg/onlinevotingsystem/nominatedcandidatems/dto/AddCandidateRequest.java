package com.cg.onlinevotingsystem.nominatedcandidatems.dto;

public class AddCandidateRequest {

    private String nominationFormNo;
    private int voterID;

    public AddCandidateRequest(String nominationFormNo, int voterID) {
        this.nominationFormNo = nominationFormNo;
        this.voterID = voterID;
    }

    public String getNominationFormNo() {
        return nominationFormNo;
    }

    public void setNominationFormNo(String nominationFormNo) {
        this.nominationFormNo = nominationFormNo;
    }

    public int getVoterID() {
        return voterID;
    }

    public void setVoterID(int voterID) {
        this.voterID = voterID;
    }
}
