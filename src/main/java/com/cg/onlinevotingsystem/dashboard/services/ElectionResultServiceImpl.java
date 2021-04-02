package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.dashboard.dao.IElectionResultRepository;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.CandidateNotFoundException;
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


    /**
     * This method saves a new ElectionResult record in the database.
     * @param candidate  The candidate for whom the vote has been cast
     * @param coopSocietyName   The society the candidate belongs to
     * @param totalPolledVotes  The total no. of votes polled so far
     * @param totalCandidateVotes  The total no. of the votes the candidate has obtained so far
     * @param candidatesVotesPercentage  The percentage of votes the candidate has obtained so far
     * @param result  The result of the election
     * @return  Returns the saved ElectionResult entity object
     */
    @Override
    public ElectionResult addElectionResult(NominatedCandidates candidate, String coopSocietyName, int totalPolledVotes, int totalCandidateVotes, float candidatesVotesPercentage, String result) {
        return electionResultRepository.save(new ElectionResult(candidate, coopSocietyName, totalPolledVotes, totalCandidateVotes, candidatesVotesPercentage, result));
    }


    /**
     * This method return all records of ElectionResult in the database
     * @return List of ElectionResult objects
     */
    @Override
    public List<ElectionResult> viewElectionResultList() {
        return electionResultRepository.findAll();
    }


    /**
     * This method returns the result for a particular candidate.
     * @param candidateID  The ID of the candidate for whom the record is to be retrieved
     * @return  An ElectionResult object pertaining to the specified candidate
     */
    @Override
    public ElectionResult viewCandidatewiseResult(int candidateID) {
        Optional<NominatedCandidates> resultOptional = candidateRepository.findById(candidateID);
        if(resultOptional.isPresent())
            return electionResultRepository.findByCandidate(resultOptional.get());
        else
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " was not found!");
    }


    /**
     * This methods return the total percentage of votes that have been cast so far
     * @return Percentage of total polled votes.
     */
    @Override
    public float viewVotingPercentage() {
        List<RegisteredSocietyVoters> voters = votersService.viewRegisteredVoterList();
        int voteCount = getTotalVotes();
        float votingPercentage = ((float) voteCount/(float) voters.size());
        return votingPercentage;
    }


    /**
     * This method return the percentage of vote obtained by a particular candidate.
     * @param candidateID  The ID of the candidate for whom the poll is to be calculated
     * @return  Percentage of votes obtained by the specified candidate
     */
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

    /**
     * This methods returns the record of the candidate who has obtained the highest percentage of votes so far
     * @return  A NominatedCandidate object of the candidate with the highest percentage of votes
     */
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


    /**
     * This methods returns the record of the candidate who has obtained the lowest percentage of votes so far
     * @return  A NominatedCandidate object of the candidate with the lowest percentage of votes
     */
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

    /**
     * This methods returns the count of the collective no. of votes that been cast so far
     * @return The count of all the votes that have been cast so far
     */
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
