package com.cg.onlinevotingsystem.votedlistms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.VotedListServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;

public class VotedListUI {

    @Autowired
    VotedListServiceImpl votedListService;

    void start(){

        RegisteredSocietyVoters voter=new RegisteredSocietyVoters("A001", "Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006, true, null);
        NominatedCandidates candidate=new NominatedCandidates();
        CooperativeSociety society = new CooperativeSociety( "Meraki", "Dev", "Verumbakam","Mesur", "Teni", "603203");

        System.out.println();


    }

}
