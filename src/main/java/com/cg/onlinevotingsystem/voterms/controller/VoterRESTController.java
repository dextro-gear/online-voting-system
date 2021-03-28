package com.cg.onlinevotingsystem.voterms.controller;

import com.cg.onlinevotingsystem.voterms.dto.CreateVoterRequest;
import com.cg.onlinevotingsystem.voterms.dto.VoterDetails;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import com.cg.onlinevotingsystem.voterms.util.VoterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voter")
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
    private IRegisteredSocietyVotersService service;

    @Autowired
    private VoterUtil util;

    @PostMapping("/add")
    public VoterDetails addNewVoter(@RequestBody CreateVoterRequest request){
        return util.details(service.voterRegistration(request.getVoterIDCardNo(),request.getFirstName(),
                request.getLastName(),request.getGender(),request.getPassword(),request.getReservationCategory(),
                request.getMobileNo(),request.getEmailID(),request.getAddress1(),request.getAddress2(),
                request.getMandal(),request.getDistrict(),request.getPincode(),request.getCastedVote(),
                request.getCooperativeSociety()));
    }

    @GetMapping("/byid/{id}")
    public VoterDetails findVoter(@PathVariable("id") int id)
    {
        RegisteredSocietyVoters sv = service.searchByVoterID(id);
        return util.details(sv);
    }

    @DeleteMapping("byid/{id}")
    public VoterDetails deleteVoter(@PathVariable("id") int id)
    {
        RegisteredSocietyVoters sv = service.deleteRegisteredVoter(id);
        return util.details(sv);
    }

    @PutMapping
    public String updateVoter(){
        return "updateVoterDetails";
    }

    @PutMapping
    public String viewVoterList()
    {
        return "viewVoterList";
    }















}
