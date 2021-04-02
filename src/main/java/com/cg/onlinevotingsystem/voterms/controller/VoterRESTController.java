package com.cg.onlinevotingsystem.voterms.controller;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import com.cg.onlinevotingsystem.voterms.dto.CreateVoterRequest;
import com.cg.onlinevotingsystem.voterms.dto.UpdateVoterRequest;
import com.cg.onlinevotingsystem.voterms.dto.VoterDetails;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import com.cg.onlinevotingsystem.voterms.util.VoterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 */
@RestController
@RequestMapping("/voters")
public class VoterRESTController {

    /* TODO
        Voter REST Endpoints
    *   1. Add voter
    *   2. Update voter details
    *   3. Delete voter
    *   4. View voter by ID
    *   5. View voter list
    * */

    @Autowired
    private IRegisteredSocietyVotersService voterService;

    @Autowired
    private ICooperativeSocietyService societyService;

    @Autowired
    private VoterUtil util;

    @PostMapping("/add")
    public VoterDetails addNewVoter(@RequestBody @Valid CreateVoterRequest request) {
        RegisteredSocietyVoters voter = util.toVoterEntity(request);
        CooperativeSociety society = societyService.viewSocietyById(request.getSocietyId());
        voter.setSociety(society);
        voter = voterService.voterRegistration(voter);
        return util.details(voter);
    }

    @PutMapping("/updatevoter")
    public VoterDetails updateVoter(UpdateVoterRequest requestData) {
        RegisteredSocietyVoters voter =util.toVoterEntity(requestData);
        voter=voterService.updateRegisteredVoterDetails(voter);
        return util.details(voter) ;
    }


    @GetMapping("/{id}")
    public VoterDetails findVoter(@PathVariable("id") int id) {
        RegisteredSocietyVoters details = voterService.searchByVoterID(id);
        return util.details(details);
    }

    @DeleteMapping("/{id}")
    public VoterDetails deleteVoter(@PathVariable("id") int id) {
        RegisteredSocietyVoters details = voterService.deleteRegisteredVoter(id);
        return util.details(details);
    }



}
