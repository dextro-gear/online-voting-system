package com.cg.onlinevotingsystem.votedlistms.dto;

public class searchByNominatedCandidateIdRequest {

    int candidateId;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public searchByNominatedCandidateIdRequest(int candidateId) {
        this.candidateId = candidateId;


    }
}
