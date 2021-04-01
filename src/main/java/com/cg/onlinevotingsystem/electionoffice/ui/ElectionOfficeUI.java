package com.cg.onlinevotingsystem.electionoffice.ui;

import com.cg.onlinevotingsystem.electionoffice.service.ElectionOfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElectionOfficeUI {

    @Autowired
    ElectionOfficeServiceImpl officeService;

    public void start(){
        officeService.addElectionOfficer("Raja", "Sundaram", "password", "male", "9080597245", "gm1687@srmist.edu.in", "Chrompet", "Chennai", "Kancheepuram");
    }

}
