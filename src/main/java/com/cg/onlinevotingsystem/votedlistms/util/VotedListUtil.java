package com.cg.onlinevotingsystem.votedlistms.util;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.dto.VotedListDTO;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class VotedListUtil {

    public VotedListDTO toDTO(VotedList vote){
        NominatedCandidates candidate=vote.getCandidate();
        String candidateFirstName=candidate.getSocietyVoter().getFirstName();
        String candidateLastName=candidate.getSocietyVoter().getLastName();
        String votingTime=vote.getPollingDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new VotedListDTO()
                .setVoteId(vote.getId())
                .setCandidateId(candidate.getCandidateID())
                .setSocietyId(vote.getSociety().getSocietyId())
                .setCandidateFirstName(candidateFirstName).
                setCandidateLastName(candidateLastName)
                .setVotingDateTime(votingTime);
    }

    public List<VotedListDTO> toDTO(List<VotedList> votes){
        List<VotedListDTO> returnList = new ArrayList<VotedListDTO>();
        for(VotedList v: votes){
            returnList.add(toDTO(v));
        }
        return returnList;
    }

}
