package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class voterUI {

    @Autowired
    IRegisteredSocietyVotersService service;

    public static void main(String[] args) {
        voterUI app=new voterUI();
        app.display();
    }

    public void display() {
        System.out.println("\nVoter Creation..........");
        RegisteredSocietyVoters t1 = service.voterRegistration("A001","Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006,true, null);

        System.out.println(t1);

        System.out.println();
        System.out.println("\nView Voter Details..........");
        System.out.println();
        List<RegisteredSocietyVoters> list = service.viewRegisteredVoterList();
        System.out.println("\nVoter Details------->" +list);


        System.out.println();
        System.out.println("\nSearch Voter By Id..........");
        System.out.println();

        RegisteredSocietyVoters t2 = service.searchByVoterID(t1.getId());
        System.out.println(t2);

        System.out.println();
        System.out.println("\nDelete Voter..........");
        System.out.println();

        RegisteredSocietyVoters t3 = service.deleteRegisteredVoter(t1.getId());
        System.out.println("\nVoter deleted");

    }

}
