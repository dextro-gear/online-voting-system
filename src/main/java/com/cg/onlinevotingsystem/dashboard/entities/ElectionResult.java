package com.cg.onlinevotingsystem.dashboard.entities;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class ElectionResult {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private NominatedCandidates candidate;

    private LocalDate pollingDate;
    private String cooperativeSocietyName;
    private int totalSocietyVotes;
    private int totalCandidateVotes;
    private float candidatesVotesPercentage;
    private String result;

    public ElectionResult(NominatedCandidates candidate, String cooperativeSocietyName, int totalSocietyVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result) {
        this.candidate = candidate;
        this.pollingDate = LocalDate.now();
        this.cooperativeSocietyName = cooperativeSocietyName;
        this.totalSocietyVotes = totalSocietyVotes;
        this.totalCandidateVotes = totalCandidateVotes;
        this.candidatesVotesPercentage = candidatesVotesPercentage;
        this.result = result;
    }

    public ElectionResult(String cooperativeSocietyName, int totalSocietyVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result) {
        this.pollingDate = LocalDate.now();
        this.cooperativeSocietyName = cooperativeSocietyName;
        this.totalSocietyVotes = totalSocietyVotes;
        this.totalCandidateVotes = totalCandidateVotes;
        this.candidatesVotesPercentage = candidatesVotesPercentage;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public NominatedCandidates getCandidate() {
        return candidate;
    }

    public void setCandidate(NominatedCandidates candidate) {
        this.candidate = candidate;
    }

    public LocalDate getPollingDate() {
        return pollingDate;
    }

    public void setPollingDate(LocalDate pollingDate) {
        this.pollingDate = pollingDate;
    }

    public String getCooperativeSocietyName() {
        return cooperativeSocietyName;
    }

    public void setCooperativeSocietyName(String cooperativeSocietyName) {
        this.cooperativeSocietyName = cooperativeSocietyName;
    }

    public int getTotalSocietyVotes() {
        return totalSocietyVotes;
    }

    public void setTotalSocietyVotes(int totalSocietyVotes) {
        this.totalSocietyVotes = totalSocietyVotes;
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
}
