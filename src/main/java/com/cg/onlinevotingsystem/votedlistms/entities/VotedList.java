package com.cg.onlinevotingsystem.votedlistms.entities;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
@Entity
public class VotedList {

    @GeneratedValue
    @Id
    private int id;
    private Date pollingDateTime;

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
        this.pollingDateTime = null;
    }

    public int getId() {
        return id;
    }


    public Date getPollingDateTime() {
        return pollingDateTime;
    }

    public void setPollingDateTime(Date pollingDateTime) {
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
}
