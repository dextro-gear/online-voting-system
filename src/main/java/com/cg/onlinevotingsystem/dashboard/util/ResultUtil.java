package com.cg.onlinevotingsystem.dashboard.util;

import com.cg.onlinevotingsystem.dashboard.dto.ElectionResultDto;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultUtil {

    public ElectionResultDto toDetails(ElectionResult result){
        ElectionResultDto details = new ElectionResultDto();
        NominatedCandidates candidate = result.getCandidate();
        String candidateName = candidate.getSocietyVoter().getFirstName() + candidate.getSocietyVoter().getLastName();

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

}
