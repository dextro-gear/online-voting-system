package com.cg.onlinevotingsystem.votedlistms.controller;


import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.dao.IVotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.dto.*;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.IVotedListService;
import com.cg.onlinevotingsystem.votedlistms.util.VotedListUtil;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@Validated
@RequestMapping("/vote")
@RestController
public class VotedListController {

    @Autowired
    private IVotedListService votedListService;

    @Autowired
    private CooperativeSocietyServiceImpl societyService;

    @Autowired
    private RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    private NominatedCandidateServiceImpl candidateService;

    @Autowired
    private IVotedListRepository votedListRepository;

    @Autowired
    private VotedListUtil votedListUtil;

    // cast a vote
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public CastVotedListResponse castNewVote(@RequestBody @Valid CastVotedListRequest request){
        CooperativeSociety society = societyService.viewSocietyById(request.getSocietyID());
        NominatedCandidates candidate = candidateService.searchByCandidateID(request.getCandidateID());
        RegisteredSocietyVoters voter = votersService.searchByVoterID(request.getVoterID());
        votedListService.castVotedList(voter, candidate, society);
        return new CastVotedListResponse("Vote Successful!", request.getCandidateID());
    }

    // view all the votes
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<VotedListDTO> viewVotedList() {
        List<VotedList> votes = votedListService.viewVotedList();
        return votedListUtil.toDTO(votes);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("byId/{id}")
    public VotedListDTO deleteVotedListDetails(@PathVariable("id") @Min(1) int id){
        return votedListUtil.toDTO(votedListService.deletedVotedListDetails(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("byVoterId/{id}")
    public VotedListDTO searchByVoterId(@PathVariable("id") @Min(1) int id){
        return votedListUtil.toDTO(votedListService.searchByVoterId(id));
    }

}
