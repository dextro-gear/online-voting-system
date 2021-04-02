package com.cg.onlinevotingsystem.dashboard.entities;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ElectionResult {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    private NominatedCandidates candidate;

    private LocalDate pollingDate;
    private String cooperativeSocietyName;
    private int totalPolledVotes;
    private int totalCandidateVotes;
    private float candidatesVotesPercentage;
    private String result;

    public ElectionResult(){
    }

    public ElectionResult(NominatedCandidates candidate, String cooperativeSocietyName, int totalPolledVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result) {
        this.candidate = candidate;
        this.pollingDate = LocalDate.now();
        this.cooperativeSocietyName = cooperativeSocietyName;
        this.totalPolledVotes = totalPolledVotes;
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

    @Override
    public String toString() {
        return "ElectionResult{" +
                "id=" + id +
                ", pollingDate=" + pollingDate +
                ", cooperativeSocietyName='" + cooperativeSocietyName + '\'' +
                ", totalPolledVotes=" + totalPolledVotes +
                ", totalCandidateVotes=" + totalCandidateVotes +
                ", candidatesVotesPercentage=" + candidatesVotesPercentage +
                ", result='" + result + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectionResult)) return false;
        ElectionResult result1 = (ElectionResult) o;
        return id == result1.id && totalPolledVotes == result1.totalPolledVotes && totalCandidateVotes == result1.totalCandidateVotes && Float.compare(result1.candidatesVotesPercentage, candidatesVotesPercentage) == 0 && Objects.equals(candidate, result1.candidate) && Objects.equals(pollingDate, result1.pollingDate) && Objects.equals(cooperativeSocietyName, result1.cooperativeSocietyName) && Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, candidate, pollingDate, cooperativeSocietyName, totalPolledVotes, totalCandidateVotes, candidatesVotesPercentage, result);
    }
}
