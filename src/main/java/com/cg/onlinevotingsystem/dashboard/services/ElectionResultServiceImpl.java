package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;

import java.util.List;

public class ElectionResultServiceImpl implements IElectionResultService{

    @Override
    public ElectionResult addElectionResult(NominatedCandidates candidate, String coopSocietyName, int totalSocietyVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result) {
        return null;
    }

    @Override
    public List<ElectionResult> viewElectionResultList() {
        return null;
    }

    @Override
    public ElectionResult viewCandidatewiseResult(int candidateID) {
        return null;
    }

    @Override
    public float viewVotingPercentage() {
        return 0;
    }

    @Override
    public float viewCandidateVotingPercentage(int candidateID) {
        return 0;
    }

    @Override
    public void displayVotingStatistics() {

    }

    @Override
    public NominatedCandidates viewHighestVotingPercentCandidate() {
        return null;
    }

    @Override
    public NominatedCandidates viewLowestVotingPercentCandidate() {
        return null;
    }

    @Override
    public int viewInvalidVotes() {
        return 0;
    }

    @Override
    public List<NominatedCandidates> candidatewiseInvalidVotesList() {
        return null;
    }

    @Override
    public void displayPollingResult() {

    }
}
