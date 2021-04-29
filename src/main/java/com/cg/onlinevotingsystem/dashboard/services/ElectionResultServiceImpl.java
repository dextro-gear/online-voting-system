package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import com.cg.onlinevotingsystem.dashboard.dao.IElectionResultRepository;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.exceptions.InvalidResultException;
import com.cg.onlinevotingsystem.dashboard.exceptions.ResultNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.INominatedCandidatesService;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.VotedListServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElectionResultServiceImpl implements IElectionResultService {

    @Autowired
    private INominatedCandidateRepository candidateRepository;

    @Autowired
    private IElectionResultRepository resultRepository;

    @Autowired
    private IRegisteredSocietyVotersService votersService;

    @Autowired
    private ICooperativeSocietyService societyService;

    @Autowired
    private INominatedCandidatesService candidateService;

    @Autowired
    private VotedListServiceImpl votedListService;


    /**
     * This method saves a new ElectionResult record in the database.
     *
     * @param result  The result of the election
     * @return Returns the saved ElectionResult entity object
     */
    @Override
    public ElectionResult addElectionResult(ElectionResult result) {
        validateResult(result);
        return resultRepository.save(result);
    }

    /**
     * This method return all records of ElectionResult in the database
     *
     * @return List of ElectionResult objects
     */
    @Override
    public List<ElectionResult> viewElectionResultList() {
        return resultRepository.findAll();
    }


    /**
     * This method returns the result for a particular candidate.
     *
     * @param candidateID The ID of the candidate for whom the record is to be retrieved
     * @return An ElectionResult object pertaining to the specified candidate
     */
    @Override
    public ElectionResult viewCandidatewiseResult(int candidateID) {
        NominatedCandidates candidate = candidateService.searchByCandidateID(candidateID);
        ElectionResult result =  resultRepository.findElectionResultByCandidate(candidate);
        if(result==null){
           throw new ResultNotFoundException("Result not found for candidate");
        }
        return result;
    }


    /**
     * This methods return the total percentage of votes that have been cast so far
     *
     * @return Percentage of total polled votes.
     */
    @Override
    public float viewVotingPercentage() {
        List<RegisteredSocietyVoters> voters = votersService.viewRegisteredVoterList();
        int voteCount = getTotalVotes();
        float votingPercentage = ((float) voteCount / (float) voters.size());
        return votingPercentage;
    }


    /**
     * This method return the percentage of vote obtained by a particular candidate.
     *
     * @param candidateID The ID of the candidate for whom the poll is to be calculated
     * @return Percentage of votes obtained by the specified candidate
     */
    @Override
    public float viewCandidateVotingPercentage(int candidateID) {
        List<VotedList> candidateVotes = votedListService.searchByNominatedCandidateId(candidateID);
        int totalVoteCount = getTotalVotes();
        float percentage = ((float) candidateVotes.size() / (float) totalVoteCount);
        return percentage;
    }


    /**
     * This methods returns the record of the candidate who has obtained the highest percentage of votes so far
     *
     * @return A NominatedCandidate object of the candidate with the highest percentage of votes
     */
    @Override
    public NominatedCandidates viewHighestVotingPercentCandidate() {
        Map<NominatedCandidates, Double> voteMap = new HashMap<>();
        List<NominatedCandidates> candidatesList = candidateService.viewNominatedCandidateList();
        for (NominatedCandidates candidate : candidatesList) {
            double percentage = viewCandidateVotingPercentage(candidate.getCandidateID());
            voteMap.put(candidate, percentage);
        }
        Map.Entry<NominatedCandidates, Double> maxEntry = Collections.max(voteMap.entrySet(), Comparator.comparing(Map.Entry::getValue));
        return maxEntry.getKey();
    }


    /**
     * This methods returns the record of the candidate who has obtained the lowest percentage of votes so far
     *
     * @return A NominatedCandidate object of the candidate with the lowest percentage of votes
     */
    @Override
    public NominatedCandidates viewLowestVotingPercentCandidate() {
        Map<NominatedCandidates, Float> voteMap = new HashMap<>();
        List<NominatedCandidates> candidatesList = candidateService.viewNominatedCandidateList();
        for (NominatedCandidates candidate : candidatesList) {
            float percentage = viewCandidateVotingPercentage(candidate.getCandidateID());
            voteMap.put(candidate, percentage);
        }
        Map.Entry<NominatedCandidates, Float> maxEntry = Collections.min(voteMap.entrySet(), Comparator.comparing(Map.Entry::getValue));

        return maxEntry.getKey();
    }


    /**
     * This methods returns the count of the collective no. of votes that been cast so far
     *
     * @return The count of all the votes that have been cast so far
     */
    public int getTotalVotes() {
        List<RegisteredSocietyVoters> voters = votersService.viewRegisteredVoterList();
        int voteCount = 0;
        for (RegisteredSocietyVoters voter : voters) {
            if (voter.getCastedVote())
                voteCount++;
        }
        return voteCount;
    }

    @Override
    public void displayPollingResult() {
        List<NominatedCandidates> candidates = candidateService.viewNominatedCandidateList();

        for(NominatedCandidates candidate: candidates){
            List<VotedList> votes = votedListService.searchByNominatedCandidateId(candidate.getCandidateID());
            float votePercentage = viewCandidateVotingPercentage(candidate.getCandidateID());
            int voteCount = votes.size();
            int totalVotes = getTotalVotes();

            ElectionResult result = new ElectionResult();
            result.setCandidate(candidate);
            result.setCooperativeSocietyName(candidate.getSocietyVoter().getSociety().getSocietyName());
            result.setCandidatesVotesPercentage(votePercentage);
            result.setTotalPolledVotes(totalVotes);
            result.setTotalCandidateVotes(voteCount);
            result.setResult("Not elected");

            addElectionResult(result);
        }

        NominatedCandidates winner = viewHighestVotingPercentCandidate();
        ElectionResult winnerResult = viewCandidatewiseResult(winner.getCandidateID());
        winnerResult.setResult("Elected");
        addElectionResult(winnerResult);
    }

    void validateResult(ElectionResult result) {
        if (result == null) {
            throw new InvalidResultException("Result cannot be null");
        }

        if (result.getCandidate() == null) {
            throw new InvalidResultException("Candidate cannot be null in result");
        }

        if (result.getCooperativeSocietyName() == null || result.getCooperativeSocietyName().isEmpty()) {
            throw new InvalidResultException("Society cannot be null or empty");

        }

    }
}
