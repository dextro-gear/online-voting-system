package com.cg.onlinevotingsystem.votedlistms.controller;


import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.dao.IVotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.dto.*;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.IVotedListService;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/votedList")
@RestController
public class VotedListController {

    @Autowired
    private IVotedListService votedListService;

    @Autowired
    private CooperativeSocietyServiceImpl societyService;

    @Autowired
    private RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    IVotedListRepository votedListRepository;

   // @Autowired
    //private VotedListUtil util;

    /*
    * 1. Add new votes (castVotedList)
    * 2. Update vote details. (updateVotedListDetails)
    * 3. Viewing which voter cast which vote. (searchByVoterID)
    * 4. View all the votes. (viewVotedList)
    * 5. Retrieve all votes for certain candidate
    * 6. Delete a vote.
    * */

    // cast a vote
    @PostMapping("/add")
    public CastVotedListResponse castNewVote(@RequestBody CastVotedListRequest request){
        int candidateID;
        // cast the vote
        CooperativeSociety society = societyService.viewSocietyById(request.getSocietyID());
        NominatedCandidates candidate = candidateService.searchByCandidateID(request.getCandidateID());
        RegisteredSocietyVoters voter = votersService.searchByVoterID(request.getVoterID());
        votedListService.castVotedList(voter, candidate, society);
        return new CastVotedListResponse("Vote Successful!", request.getCandidateID());
    }

    // view all the votes
    @GetMapping("/view")
    public List<VotedList> viewVotedList() {
        List<VotedList> votes = votedListService.viewVotedList();
        return votes;
    }

    @DeleteMapping("byId/{id}")
    public String deleteVotedListDetails(@PathVariable("id")int id){
        Optional<VotedList> optionalVotedList = votedListRepository.findById(id);
        votedListService.deletedVotedListDetails(id);
        return "VotedList details deleted " + id;
    }

    @GetMapping("byVoterId/{id}")
    public SearchByVoterIdRequest searchByVoterId(@PathVariable("id")int id){
        Optional<VotedList> votedList=votedListRepository.findById(id);


        return null;
    }








}
