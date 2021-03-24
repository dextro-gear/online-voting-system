package com.cg.onlinevotingsystem.cooperativesocietyms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;

@Component
public class CooperativeSocietyUI {
	@Autowired
	ICooperativeSocietyService service;
	
	public void display() {
		CooperativeSociety s1 = new CooperativeSociety(1, "Meraki", "Dev", "Verumbakam","Mesur", "Teni", "603203");

		System.out.println(s1);
	}
	


}
