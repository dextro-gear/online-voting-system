package com.cg.onlinevotingsystem;

import com.cg.onlinevotingsystem.cooperativesocietyms.ui.CooperativeSocietyUI;
import com.cg.onlinevotingsystem.dashboard.ui.DashboardUI;
import com.cg.onlinevotingsystem.nominatedcandidatems.ui.CandidatesUI;
import com.cg.onlinevotingsystem.votedlistms.ui.VotedListUI;
import com.cg.onlinevotingsystem.voterms.ui.VoterUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OnlineVotingSystemApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(OnlineVotingSystemApplication.class, args);

		CooperativeSocietyUI cooperativeSocietyUI = context.getBean(CooperativeSocietyUI.class);
		cooperativeSocietyUI.display();

		VoterUI voterUI = context.getBean(VoterUI.class);
		voterUI.display();

		CandidatesUI candidatesUI = context.getBean(CandidatesUI.class);
		candidatesUI.start();

		VotedListUI votedListUI= context.getBean(VotedListUI.class);
		votedListUI.start();

		DashboardUI dashboardUI = context.getBean(DashboardUI.class);
		dashboardUI.start();
	}

}
