package com.cg.onlinevotingsystem.votedlistms.controller;


import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.dto.*;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.IVotedListService;
import com.cg.onlinevotingsystem.votedlistms.util.VotedListUtil;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/votedList")
@RestController
public class VotedListController {

    @Autowired
    private IVotedListService service;

    @Autowired
    private CooperativeSocietyServiceImpl societyService;

    @Autowired
    private RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    NominatedCandidateServiceImpl candidateService;

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
        service.castVotedList(voter, candidate, society);
        return new CastVotedListResponse("Vote Successful!", request.getCandidateID());
    }

    // view all the votes
    @GetMapping("/view")
    public List<VotedList> viewVotedList() {
        List<VotedList> votes = service.viewVotedList();
        return votes;
    }

    @DeleteMapping("byId/{id}")
    public DeleteVotedListRequest deleteVotedListDetails(){
        RegisteredSocietyVoters  voter =votersService.searchByVoterID(deleteVotedListDetails().getId());
        return new DeleteVotedListRequest("Data of given id is removed", voter.getId());
    }





}
