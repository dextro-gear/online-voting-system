package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;

import java.util.List;

public interface IElectionResultService {


    ElectionResult addElectionResult(ElectionResult result);

    List<ElectionResult> viewElectionResultList();

    ElectionResult viewCandidatewiseResult(int candidateID);

    float viewVotingPercentage();

    float viewCandidateVotingPercentage(int candidateID);

    void displayPollingResult();

    NominatedCandidates viewHighestVotingPercentCandidate();

    NominatedCandidates viewLowestVotingPercentCandidate();


}
