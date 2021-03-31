package com.cg.onlinevotingsystem.votedlistms.dto;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import java.time.LocalDateTime;

public class VotedListDTO {

    int voteId;
    int candidateId;
    int societyId;
    String votingDateTime;

    public VotedListDTO() {
    }

    public VotedListDTO(int voteId, int candidateId, int societyId, String votingDateTime) {
        this.voteId = voteId;
        this.candidateId = candidateId;
        this.societyId = societyId;
        this.votingDateTime = votingDateTime;
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
}
