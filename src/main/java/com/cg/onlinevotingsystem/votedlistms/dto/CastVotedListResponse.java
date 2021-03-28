package com.cg.onlinevotingsystem.votedlistms.dto;

public class CastVotedListResponse {
    String response;
    int candidateID;

    public CastVotedListResponse(){}

    public CastVotedListResponse(String response, int candidateID) {
        this.response = response;
        this.candidateID = candidateID;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }
}
