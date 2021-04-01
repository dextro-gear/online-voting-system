package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.dashboard.dao.IElectionResultRepository;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.VotedListServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElectionResultServiceImpl implements IElectionResultService{

    @Autowired
    INominatedCandidateRepository candidateRepository;

    @Autowired
    IElectionResultRepository electionResultRepository;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    VotedListServiceImpl votedListService;

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
        List<RegisteredSocietyVoters> voters = votersService.viewRegisteredVoterList();
        int voteCount = getTotalVotes();
        float votingPercentage = ((float) voteCount/(float) voters.size());
        return votingPercentage;
    }

    @Override
    public float viewCandidateVotingPercentage(int candidateID) {
        List<VotedList> candidateVotes = votedListService.searchByNominatedCandidateId(candidateID);
        int totalVoteCount = getTotalVotes();
        float percentage = ((float) candidateVotes.size() / (float) totalVoteCount);
        return percentage;
    }

    @Override
    public void displayVotingStatistics() {

    }

    @Override
    public NominatedCandidates viewHighestVotingPercentCandidate() {
        Map<NominatedCandidates, Float> voteMap = new HashMap<>();
        List<NominatedCandidates> candidatesList = candidateService.viewNominatedCandidateList();
        for(NominatedCandidates candidate: candidatesList){
            float percentage = viewCandidateVotingPercentage(candidate.getCandidateID());
            voteMap.put(candidate, viewCandidateVotingPercentage(candidate.getCandidateID()));
        }
        Map.Entry<NominatedCandidates, Float> maxEntry = Collections.max(voteMap.entrySet(), Comparator.comparing(Map.Entry::getValue));

        return maxEntry.getKey();
    }

    @Override
    public NominatedCandidates viewLowestVotingPercentCandidate() {
        Map<NominatedCandidates, Float> voteMap = new HashMap<>();
        List<NominatedCandidates> candidatesList = candidateService.viewNominatedCandidateList();
        for(NominatedCandidates candidate: candidatesList){
            float percentage = viewCandidateVotingPercentage(candidate.getCandidateID());
            voteMap.put(candidate, viewCandidateVotingPercentage(candidate.getCandidateID()));
        }
        Map.Entry<NominatedCandidates, Float> maxEntry = Collections.min(voteMap.entrySet(), Comparator.comparing(Map.Entry::getValue));

        return maxEntry.getKey();
    }

    @Override
    public void displayPollingResult() {
    }

    public int getTotalVotes(){
        List<RegisteredSocietyVoters> voters = votersService.viewRegisteredVoterList();
        int voteCount = 0;
        for(RegisteredSocietyVoters voter: voters){
            if(voter.getCastedVote())
                voteCount++;
        }
        return voteCount;
    }
}
