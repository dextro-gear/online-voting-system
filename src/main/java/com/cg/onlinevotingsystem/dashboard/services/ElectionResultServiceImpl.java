package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.dashboard.dao.IElectionResultRepository;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionResultServiceImpl implements IElectionResultService{

    @Autowired
    INominatedCandidateRepository candidateRepository;

    @Autowired
    IElectionResultRepository electionResultRepository;

    @Override
    public ElectionResult addElectionResult(NominatedCandidates candidate, String coopSocietyName, int totalSocietyVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result) {
        return electionResultRepository.save(new ElectionResult(candidate, coopSocietyName, totalSocietyVotes, totalCandidateVotes, candidatesVotesPercentage, result));
    }

    @Override
    public List<ElectionResult> viewElectionResultList() {
        return electionResultRepository.findAll();
    }

    @Override
    public ElectionResult viewCandidatewiseResult(int candidateID) {
        Optional<NominatedCandidates> resultOptional = candidateRepository.findById(candidateID);
        if(resultOptional.isPresent())
            return electionResultRepository.findByCandidate(resultOptional.get());
        else
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " was not found!");
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
