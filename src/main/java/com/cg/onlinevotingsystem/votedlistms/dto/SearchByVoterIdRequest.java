package com.cg.onlinevotingsystem.votedlistms.dto;

public class SearchByVoterIdRequest {
    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    int voterId;

    public SearchByVoterIdRequest(int voterId) {
        this.voterId = voterId;
    }




}
