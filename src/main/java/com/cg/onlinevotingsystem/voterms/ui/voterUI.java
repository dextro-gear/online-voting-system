package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class voterUI {

    @Autowired
    IRegisteredSocietyVotersService service;

    public static void main(String[] args) {
        voterUI app=new voterUI();
        app.display();
    }

    public void display() {
        System.out.println("Voter Creation..........");
        RegisteredSocietyVoters t1 = service.voterRegistration("A001","Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006, "Society 1", true);
        System.out.println(t1);


        System.out.println();
        System.out.println("Delete Voter..........");
        System.out.println();

        RegisteredSocietyVoters t2 = service.deleteRegisteredVoter(int id);
        System.out.println("Voter deleted");

        System.out.println();
        System.out.println("Search Voter by ID..........");
        System.out.println();


        RegisteredSocietyVoters t3 = service.searchByVoterID(int id);
        System.out.println("Voter found");
    }
}
