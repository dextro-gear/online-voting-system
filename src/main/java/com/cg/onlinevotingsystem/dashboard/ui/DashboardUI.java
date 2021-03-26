package com.cg.onlinevotingsystem.dashboard.ui;

import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.services.ElectionResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardUI {

    @Autowired
    ElectionResultServiceImpl electionResultService;

    public void start(){
        System.out.println(electionResultService.addElectionResult(null, "tanjore", 100, 60, 60, "Nominated").toString());
        System.out.println(electionResultService.addElectionResult(null, "chennai", 100, 60, 60, "Nominated").toString());
        System.out.println(electionResultService.addElectionResult(null, "mumbai", 100, 60, 60, "Nominated").toString());
    }
}
