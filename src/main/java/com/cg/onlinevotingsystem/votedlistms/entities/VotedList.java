package com.cg.onlinevotingsystem.votedlistms.entities;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class VotedList {

    @GeneratedValue
    @Id
    private int id;
    private LocalDateTime pollingDateTime;

    @OneToOne
    private CooperativeSociety society;

    @OneToOne
    private RegisteredSocietyVoters voter;

    @OneToOne
    private NominatedCandidates candidate;


    public VotedList() {}

    public VotedList(RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) {
        this.candidate = candidate;
        this.voter = voter;
        this.society = society;
        this.pollingDateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }


    public LocalDateTime getPollingDateTime() {
        return pollingDateTime;
    }

    public void setPollingDateTime(LocalDateTime pollingDateTime) {
        this.pollingDateTime = pollingDateTime;
    }

    public CooperativeSociety getSociety() {
        return society;
    }

    public void setSociety(CooperativeSociety society) {
        this.society = society;
    }

    public RegisteredSocietyVoters getVoter() {
        return voter;
    }

    public void setVoter(RegisteredSocietyVoters voter) {
        this.voter = voter;
    }

    public NominatedCandidates getCandidate() {
        return candidate;
    }

    public void setCandidate(NominatedCandidates candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "VotedList{" +
                "id=" + id +
                ", pollingDateTime=" + pollingDateTime +
                ", society=" + society +
                ", voter=" + voter +
                ", candidate=" + candidate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VotedList)) return false;
        VotedList votedList = (VotedList) o;
        return id == votedList.id && Objects.equals(pollingDateTime, votedList.pollingDateTime) && Objects.equals(society, votedList.society) && Objects.equals(voter, votedList.voter) && Objects.equals(candidate, votedList.candidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pollingDateTime, society, voter, candidate);
    }
}
