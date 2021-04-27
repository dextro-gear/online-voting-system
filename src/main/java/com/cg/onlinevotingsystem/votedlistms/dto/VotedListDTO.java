package com.cg.onlinevotingsystem.votedlistms.dto;

public class VotedListDTO {

    private int voteId;
    private int candidateId;
    private String candidateFirstName;
    private String candidateLastName;
    private int societyId;
    private String votingDateTime;

    public VotedListDTO() {
    }


    public int getVoteId() {
        return voteId;
    }

    public VotedListDTO setVoteId(int voteId) {
        this.voteId = voteId;
        return this;
    }

    public String getVotingDateTime() {
        return votingDateTime;
    }

    public VotedListDTO setVotingDateTime(String votingDateTime) {
        this.votingDateTime = votingDateTime;
        return this;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public VotedListDTO setCandidateId(int candidateId) {
        this.candidateId = candidateId;
        return this;
    }

    public int getSocietyId() {
        return societyId;
    }

    public VotedListDTO setSocietyId(int societyId) {
        this.societyId = societyId;
        return this;
    }

    public String getCandidateFirstName() {
        return candidateFirstName;
    }

    public VotedListDTO setCandidateFirstName(String candidateFirstName) {
        this.candidateFirstName = candidateFirstName;
        return this;
    }

    public String getCandidateLastName() {
        return candidateLastName;
    }

    public VotedListDTO setCandidateLastName(String candidateLastName) {
        this.candidateLastName = candidateLastName;
        return this;
    }
}
