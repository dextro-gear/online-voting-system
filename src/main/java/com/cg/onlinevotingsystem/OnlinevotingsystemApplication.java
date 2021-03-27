package com.cg.onlinevotingsystem;

import com.cg.onlinevotingsystem.cooperativesocietyms.ui.CooperativeSocietyUI;
import com.cg.onlinevotingsystem.dashboard.ui.DashboardUI;
import com.cg.onlinevotingsystem.nominatedcandidatems.ui.CandidatesUI;
import com.cg.onlinevotingsystem.votedlistms.ui.VotedListUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OnlinevotingsystemApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OnlinevotingsystemApplication.class, args);
		CooperativeSocietyUI ui =context.getBean(CooperativeSocietyUI.class);
		ui.display();

		DashboardUI dashboardUI = context.getBean(DashboardUI.class);
		dashboardUI.start();

		VotedListUI votedListUI= context.getBean(VotedListUI.class);
		votedListUI.start();

		CandidatesUI candidatesUI = context.getBean(CandidatesUI.class);
		candidatesUI.start();
	}

}
