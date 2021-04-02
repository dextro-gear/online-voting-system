package com.cg.onlinevotingsystem.electionoffice.ui;

import com.cg.onlinevotingsystem.electionoffice.entities.ElectionOfficer;
import com.cg.onlinevotingsystem.electionoffice.service.ElectionOfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElectionOfficeUI {

    @Autowired
    ElectionOfficeServiceImpl officeService;

    public void start(){
        ElectionOfficer officer=new ElectionOfficer();
        officer.setFirstName("Raja").
                setLastName("Sundaram").
                setPassword("password").
                setGender("male").
                setMobileNo("9080597245").
                setEmailID("gm1687@srmist.edu.in").
                setDistrict("Kancheepuram").
                setAddress1("Chrompet").
                setAddress2("Chennai");


        officeService.addElectionOfficer(officer);
    }

}
