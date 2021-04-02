package com.cg.onlinevotingsystem.dashboard.util;

import com.cg.onlinevotingsystem.dashboard.dto.ElectionResultDto;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import org.springframework.stereotype.Component;

@Component
public class ResultUtil {

    /**
     *   private int totalPolledVotes;
     *     private int totalCandidateVotes;
     *     private float candidatesVotesPercentage;
     *     private String result;
     * @param result
     * @return
     */
   public ElectionResultDto toDetails(ElectionResult result){
       ElectionResultDto details=new  ElectionResultDto();
       details.setResult(result.getResult());
       details.setCandidatesVotesPercentage(result.getCandidatesVotesPercentage());
       details.setTotalCandidateVotes(result.getTotalCandidateVotes());
       details.setSocietyName(result.getCooperativeSocietyName());
       return details;
   }

}
