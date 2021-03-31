package com.cg.onlinevotingsystem.votedlistms.util;

import com.cg.onlinevotingsystem.votedlistms.dto.VotedListDTO;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class VotedListUtil {

    public VotedListDTO toDTO(VotedList vote){
        return new VotedListDTO()
                .setVoteId(vote.getId())
                .setCandidateId(vote.getCandidate().getCandidateID())
                .setSocietyId(vote.getSociety().getSocietyId())
                .setVotingDateTime(vote.getPollingDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public List<VotedListDTO> toDTO(List<VotedList> votes){
        List<VotedListDTO> returnList = new ArrayList<VotedListDTO>();
        for(VotedList v: votes){
            returnList.add(toDTO(v));
        }
        return returnList;
    }

}
