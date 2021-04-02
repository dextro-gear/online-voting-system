package com.cg.onlinevotingsystem.dashboard.dto;

public class ElectionResultDto {

    private int totalPolledVotes;
    private int totalCandidateVotes;
    private float candidatesVotesPercentage;
    private String result;
    private String societyName;

    public int getTotalPolledVotes() {
        return totalPolledVotes;
    }

    public void setTotalPolledVotes(int totalPolledVotes) {
        this.totalPolledVotes = totalPolledVotes;
    }

    public int getTotalCandidateVotes() {
        return totalCandidateVotes;
    }

    public void setTotalCandidateVotes(int totalCandidateVotes) {
        this.totalCandidateVotes = totalCandidateVotes;
    }

    public float getCandidatesVotesPercentage() {
        return candidatesVotesPercentage;
    }

    public void setCandidatesVotesPercentage(float candidatesVotesPercentage) {
        this.candidatesVotesPercentage = candidatesVotesPercentage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }
}
