package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;

import java.util.List;

public interface IElectionResultService {

    ElectionResult addElectionResult(NominatedCandidates candidate, String coopSocietyName, int totalSocietyVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result );
    List<ElectionResult> viewElectionResultList();
    ElectionResult viewCandidatewiseResult(int candidateID);
    float viewVotingPercentage();
    float viewCandidateVotingPercentage(int candidateID);
    void displayVotingStatistics();
    NominatedCandidates viewHighestVotingPercentCandidate();
    NominatedCandidates viewLowestVotingPercentCandidate();
    int viewInvalidVotes();
    List<NominatedCandidates> candidatewiseInvalidVotesList();
    void displayPollingResult();

}
