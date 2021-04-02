package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class VoterUI {

    @Autowired
    IRegisteredSocietyVotersService service;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    public void display() {

//        System.out.println(t1);
//
//        System.out.println();
//        System.out.println("\nView Voter Details..........");
//        System.out.println();
//        List<RegisteredSocietyVoters> list = service.viewRegisteredVoterList();
//        System.out.println("\nVoter Details------->" +list);
//
//
//        System.out.println();
//        System.out.println("\nSearch Voter By Id..........");
//        System.out.println();
//
//        RegisteredSocietyVoters t16 = service.searchByVoterID(t1.getId());
//        System.out.println(t16);
//
//        System.out.println();
//        System.out.println("\nDelete Voter..........");
//        System.out.println();
//
//        RegisteredSocietyVoters t17 = service.deleteRegisteredVoter(t1.getId());
//        System.out.println("\nVoter deleted");

    }

}
