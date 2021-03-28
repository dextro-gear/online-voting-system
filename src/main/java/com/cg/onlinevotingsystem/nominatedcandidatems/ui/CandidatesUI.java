package com.cg.onlinevotingsystem.nominatedcandidatems.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatesUI {

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    public void start(){

        CooperativeSociety s1 = new CooperativeSociety( "Meraki", "Dev", "verumbakam","Mesur", "Teni", "111111");
        CooperativeSociety s2 = new CooperativeSociety("Meluha", "Deviya", "minambakam","Meshur", "Aryalur", "222222");
        CooperativeSociety s3 = new CooperativeSociety("Sandar", "Shiv", "karrembakam","Miniasi", "Erode", "333333");
        CooperativeSociety s4 = new CooperativeSociety("Menaar", "Anika", "chanderi","Kaamna", "Jhansi", "444444");



        RegisteredSocietyVoters t1 = new RegisteredSocietyVoters("A001","Ritik", "S", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Mesur", "Theni", 111111,true, s1);
        RegisteredSocietyVoters t2 = new RegisteredSocietyVoters("A002","Raja", "A", "Male", "password2", "General", "9952688959", "raja@gmail.com", "House No. 2", "GR Nagar",
                "Mehsur", "Aryalur", 222222,true, s2);
        RegisteredSocietyVoters t3 = new RegisteredSocietyVoters("A003","Shvi", "G", "Female", "password3", "SC", "7389217147", "shivanya@gmail.com", "House No. 3", "LR Nagar",
                "Soch", "Mulugu", 999999,true, s4);
        RegisteredSocietyVoters t4 = new RegisteredSocietyVoters("A004","Samira", "H", "Female", "password4", "OBC", "9109587771", "s@gmail.com", "House No. 4", "SR Nagar",
                "Miniasi", "Erode", 333333,true, s3);


        NominatedCandidates n1 = candidateService.addNominatedCandidate("1234",t1);
        NominatedCandidates n2 = candidateService.addNominatedCandidate("5678",t3);
        NominatedCandidates n3 = candidateService.addNominatedCandidate("8765",t4);
        NominatedCandidates n4 = candidateService.addNominatedCandidate("4321", t2);



        // Add service demo.
        System.out.println("\nAddcandidate");
        System.out.println(n4);

        // find service demo
        System.out.println("\nSearch candidate");
        System.out.println(candidateService.searchByCandidateID(15).toString());

        // update service demo
        System.out.println("\nUpdate candidate");
        System.out.println(candidateService.updateNominatedCandidateDetails(12, "666666", null));
    }

}
