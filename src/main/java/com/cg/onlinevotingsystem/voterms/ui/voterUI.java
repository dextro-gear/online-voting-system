package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.stereotype.Component;

@Component
public class voterUI {

    IRegisteredSocietyVotersService service;

    public void display() {
        RegisteredSocietyVoters t1 = new RegisteredSocietyVoters("A001", "Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006, true, null);
        System.out.println(t1);
    }

}
