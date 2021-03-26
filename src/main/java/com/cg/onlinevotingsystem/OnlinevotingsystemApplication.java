package com.cg.onlinevotingsystem;

import com.cg.onlinevotingsystem.cooperativesocietyms.ui.CooperativeSocietyUI;
import com.cg.onlinevotingsystem.dashboard.ui.DashboardUI;
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
	}

}
