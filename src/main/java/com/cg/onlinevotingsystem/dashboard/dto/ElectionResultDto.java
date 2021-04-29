package com.cg.onlinevotingsystem.dashboard.dto;

public class ElectionResultDto {

    private int candidateID;
    private String candidateName;
    private int totalPolledVotes;
    private int totalCandidateVotes;
    private float candidatesVotesPercentage;
    private String result;
    private String societyName;

    public int getCandidateID() {
        return candidateID;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getTotalPolledVotes() {
        return totalPolledVotes;
    }

    public int getTotalCandidateVotes() {
        return totalCandidateVotes;
    }

    public float getCandidatesVotesPercentage() {
        return candidatesVotesPercentage;
    }

    public String getResult() {
        return result;
    }

    public String getSocietyName() {
        return societyName;
    }

    public ElectionResultDto setCandidateID(int candidateID) {
        this.candidateID = candidateID;
        return this;
    }

    public ElectionResultDto setCandidateName(String candidateName) {
        this.candidateName = candidateName;
        return this;
    }

    public ElectionResultDto setTotalPolledVotes(int totalPolledVotes) {
        this.totalPolledVotes = totalPolledVotes;
        return this;
    }

    public ElectionResultDto setTotalCandidateVotes(int totalCandidateVotes) {
        this.totalCandidateVotes = totalCandidateVotes;
        return this;
    }

    public ElectionResultDto setCandidatesVotesPercentage(float candidatesVotesPercentage) {
        this.candidatesVotesPercentage = candidatesVotesPercentage;
        return this;
    }

    public ElectionResultDto setResult(String result) {
        this.result = result;
        return this;
    }

    public ElectionResultDto setSocietyName(String societyName) {
        this.societyName = societyName;
        return this;
    }
}
