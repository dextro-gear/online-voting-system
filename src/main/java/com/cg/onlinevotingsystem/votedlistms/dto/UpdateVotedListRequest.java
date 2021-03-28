package com.cg.onlinevotingsystem.votedlistms.dto;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

public class UpdateVotedListRequest {



    RegisteredSocietyVoters voter;
    NominatedCandidates candidate;
    CooperativeSociety society;


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

    public CooperativeSociety getSociety() {
        return society;
    }

    public void setSociety(CooperativeSociety society) {
        this.society = society;
    }

    public UpdateVotedListRequest(int votedListID, RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) {
        this.voter = voter;
        this.candidate = candidate;
        this.society = society;
    }



    }
