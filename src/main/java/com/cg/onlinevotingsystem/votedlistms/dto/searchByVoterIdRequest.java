package com.cg.onlinevotingsystem.votedlistms.dto;

public class searchByVoterIdRequest {
    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    int voterId;

    public searchByVoterIdRequest(int voterId) {
        this.voterId = voterId;
    }




}
