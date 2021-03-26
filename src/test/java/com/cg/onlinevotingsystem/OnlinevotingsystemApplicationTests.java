package com.cg.onlinevotingsystem;

import com.cg.onlinevotingsystem.voterms.ui.voterUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
class OnlinevotingsystemApplicationTests {
	public static void main(String[] args){
		ConfigurableApplicationContext context = SpringApplication.run(OnlinevotingsystemApplicationTests.class, args);
		voterUI ui = context.getBean(voterUI.class);
		ui.display();
	}

}
