package com.cg.onlinevotingsystem.nominatedcandidatems.controllers;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.dto.AddCandidateRequest;
import com.cg.onlinevotingsystem.nominatedcandidatems.dto.NominatedCandidateDTO;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.util.NominatedCandidatesUtil;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class NominatedCandidateRESTController {

    /* TODO
        Nominated Candidate REST Endpoints
    *   1. Add candidate
    *   2. Update candidate
    *   3. Delete candidate
    *   4. View candidate by ID
    *   5. View all candidates
    * */

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    NominatedCandidatesUtil candidatesUtil;

    @PostMapping
    public NominatedCandidateDTO addNewCandidate(@RequestBody AddCandidateRequest request){
        RegisteredSocietyVoters voter = votersService.searchByVoterID(request.getVoterID());
        NominatedCandidates candidate = candidateService.addNominatedCandidate(request.getNominationFormNo(), voter);
        return candidatesUtil.toDTO(candidate);
    }

    @GetMapping("/{id}")
    public NominatedCandidateDTO getCandidateByID(@PathVariable("id") int candidateID){
        NominatedCandidates candidate = candidateService.searchByCandidateID(candidateID);
        return candidatesUtil.toDTO(candidate);
    }

    @GetMapping
    public String getAllCandidates(){
        return "getAllCandidates";
    }

    @PutMapping
    public String updateCandidateDetails(){
        return "updateCandidateDetails";
    }

    @DeleteMapping("/{id}")
    public String deleteCandidateByID(@PathVariable("id") int candidateID){
        return "deleteCandidateByID : " + candidateID;
    }


}
