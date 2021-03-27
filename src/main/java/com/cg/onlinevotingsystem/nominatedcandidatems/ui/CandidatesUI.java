package com.cg.onlinevotingsystem.nominatedcandidatems.ui;

import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatesUI {

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    public void start(){
        // Add service demo.
        System.out.println("\nAddcandidate");
        System.out.println(candidateService.addNominatedCandidate("123345", new RegisteredSocietyVoters("A001","Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006, true, null)).toString());

        // find service demo
        System.out.println("\nSearch candidate");
        System.out.println(candidateService.searchByCandidateID(15).toString());

        // update service demoe
        System.out.println("\nUpdate candidate");
        System.out.println(candidateService.updateNominatedCandidateDetails(12, "666666", null));
    }

}
