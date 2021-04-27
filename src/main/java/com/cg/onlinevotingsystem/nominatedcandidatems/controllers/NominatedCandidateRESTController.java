package com.cg.onlinevotingsystem.nominatedcandidatems.controllers;

import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.dto.AddCandidateRequest;
import com.cg.onlinevotingsystem.nominatedcandidatems.dto.NominatedCandidateDTO;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.util.NominatedCandidatesUtil;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import com.cg.onlinevotingsystem.voterms.util.VoterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class NominatedCandidateRESTController {

    /* TODO
        Nominated Candidate REST Endpoints
    *   2. Update candidate
    *   3. Delete candidate
    * */

    @Autowired
    private NominatedCandidateServiceImpl candidateService;

    @Autowired
    private CooperativeSocietyServiceImpl societyService;

    @Autowired
    private RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    private NominatedCandidatesUtil candidatesUtil;

    @Autowired
    private VoterUtil voterUtil;


     @PostMapping("/add")
    public NominatedCandidateDTO addNewCandidate(@RequestBody AddCandidateRequest request){
        RegisteredSocietyVoters voter = votersService.searchByVoterID(request.getVoterID());
        NominatedCandidates candidate=new NominatedCandidates(request.getNominationFormNo(),voter);
        candidate = candidateService.addNominatedCandidate(candidate);
        return candidatesUtil.toDTO(candidate);
    }

    @GetMapping("/byid/{id}")
    public NominatedCandidateDTO getCandidateByID(@PathVariable("id") int candidateID){
        NominatedCandidates candidate = candidateService.searchByCandidateID(candidateID);
        return candidatesUtil.toDTO(candidate);
    }

    @GetMapping
    public List<NominatedCandidateDTO> getAllCandidates(){
        return candidatesUtil.toDTO(candidateService.viewNominatedCandidateList());
    }



}
