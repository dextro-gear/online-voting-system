package com.cg.onlinevotingsystem.nominatedcandidatems.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatesUI {

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    public void start(){

     //System.out.println("\nAddcandidate");
//        System.out.println(n4);
//
//        System.out.println("\nUpdate candidate");
//        System.out.println(candidateService.updateNominatedCandidateDetails(12, "666666", null));
    }

}
