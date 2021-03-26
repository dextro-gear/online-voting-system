package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class voterUI {

    IRegisteredSocietyVotersService service;

    public static void main(String[] args) {
        voterUI app=new voterUI();
        app.display();
    }

    public void display() {
        System.out.println("Voter Creation..........");
        RegisteredSocietyVoters t1 = service.voterRegistration("A001","Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006, null, true);
        System.out.println(t1);

        System.out.println();
        System.out.println("View Voter Details..........");
        System.out.println();
        List<RegisteredSocietyVoters> list = service.viewRegisteredVoterList();
        System.out.println("Voter Details------->" +list);


        System.out.println();
        System.out.println("Search Voter By Id..........");
        System.out.println();

        RegisteredSocietyVoters t2 = service.searchByVoterID(t1.getId());
        System.out.println(t2);

        System.out.println();
        System.out.println("Delete Voter..........");
        System.out.println();

        RegisteredSocietyVoters t3 = service.deleteRegisteredVoter(t1.getId());
        System.out.println("Voter deleted");

    }
}
