package com.cg.onlinevotingsystem.dashboard.util;

import com.cg.onlinevotingsystem.dashboard.dto.ElectionResultDto;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.exceptions.ResultNotFoundException;
import com.cg.onlinevotingsystem.dashboard.services.ElectionResultServiceImpl;
import com.cg.onlinevotingsystem.dashboard.services.IElectionResultService;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.IVotedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultUtil {

    @Autowired
    private ElectionResultServiceImpl resultService;

    @Autowired
    private IVotedListService voteService;

    public ElectionResultDto toDetails(ElectionResult result){
        ElectionResultDto details = new ElectionResultDto();
        NominatedCandidates candidate = result.getCandidate();
        String candidateName = candidate.getSocietyVoter().getFirstName() + " " + candidate.getSocietyVoter().getLastName();

        details.setResult(result.getResult())
                .setCandidatesVotesPercentage(result.getCandidatesVotesPercentage())
                .setTotalCandidateVotes(result.getTotalCandidateVotes())
                .setSocietyName(result.getCooperativeSocietyName())
                .setCandidateID(candidate.getCandidateID())
                .setCandidateName(candidateName)
                .setTotalPolledVotes(result.getTotalPolledVotes());

        return details;
    }

    public List<ElectionResultDto> toDetails(List<ElectionResult> results){
        List<ElectionResultDto> returnList = new ArrayList<>();

        for(ElectionResult result: results){
            returnList.add(toDetails(result));
        }

        return returnList;
    }

    public ElectionResultDto constructResult(NominatedCandidates candidate) {
        ElectionResultDto result = new ElectionResultDto();
        float candidateVotingPercentage = resultService.viewCandidateVotingPercentage(candidate.getCandidateID());
        int totalPolls = resultService.getTotalVotes();
        List<VotedList> list = voteService.searchByNominatedCandidateId(candidate.getCandidateID());
        int obtainedVotes = list.size();
        String name = candidate.getSocietyVoter().getFirstName() + " " + candidate.getSocietyVoter().getLastName();
        String societyName = candidate.getSocietyVoter().getSociety().getSocietyName();
        String electionResult;
        try {
             ElectionResult candidateResult = resultService.viewCandidatewiseResult(candidate.getCandidateID());
             electionResult = candidateResult.getResult();
        } catch (ResultNotFoundException e) {
            electionResult = "Unannounced";
        }

        result.setTotalCandidateVotes(obtainedVotes)
                .setTotalPolledVotes(totalPolls)
                .setCandidateName(name)
                .setResult(electionResult)
                .setCandidateID(candidate.getCandidateID())
                .setSocietyName(societyName)
                .setCandidatesVotesPercentage(candidateVotingPercentage);

        return result;
    }

}
