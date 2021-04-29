package com.cg.onlinevotingsystem.dashboard.controllers;

import com.cg.onlinevotingsystem.dashboard.dto.ElectionResultDto;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.services.IElectionResultService;
import com.cg.onlinevotingsystem.dashboard.util.ResultUtil;
import com.cg.onlinevotingsystem.nominatedcandidatems.dto.NominatedCandidateDTO;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.util.NominatedCandidatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequestMapping("/results")
@RestController
@Validated
public class ElectionResultController {

    @Autowired
    private IElectionResultService resultService;

    @Autowired
    private ResultUtil resultUtil;

    @Autowired
    private NominatedCandidatesUtil candidatesUtil;

    @GetMapping("/bycandidate/{cid}")
    public ElectionResultDto getCandidateResult(@PathVariable("cid") @Min(1) int cid){
        ElectionResult result= resultService.viewCandidatewiseResult(cid);
        ElectionResultDto dto=resultUtil.toDetails(result);
        return dto;
    }

    @GetMapping("/votingpercentage")
    public double getVotingPercentage(){
        return resultService.viewVotingPercentage();
    }

    @GetMapping("/winner")
    public NominatedCandidateDTO getWinner(){
        NominatedCandidates candidate=resultService.viewHighestVotingPercentCandidate();
        NominatedCandidateDTO details=candidatesUtil.toDTO(candidate);
        return details;
    }


    @GetMapping("/biggestloser")
    public NominatedCandidateDTO viewLowestVotingPercentCandidate(){
        NominatedCandidates candidate=resultService.viewLowestVotingPercentCandidate();
        NominatedCandidateDTO details=candidatesUtil.toDTO(candidate);
        return details;

    }

    @GetMapping("/electionresult")
    public List<ElectionResultDto> displayElectionResult(){
        resultService.displayPollingResult();
        List<ElectionResult> resultList= resultService.viewElectionResultList();
        return resultUtil.toDetails(resultList);
    }


}
