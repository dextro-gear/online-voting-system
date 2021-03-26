package com.cg.onlinevotingsystem.cooperativesocietyms.ui;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;

import java.util.List;

@Component
public class CooperativeSocietyUI {
	@Autowired
	ICooperativeSocietyService service;
	
	public void display() {
		CooperativeSociety s1 = service.addSocietyDetails( "Meraki", "Dev", "Verumbakam","Mesur", "Teni", "603203");
		CooperativeSociety s2 = service.addSocietyDetails("sakki", "Deviya", "minambakam","Meshur", "Theni", "638231");

		//find by id implemented
		CooperativeSociety cs3 = service.viewSocietyById(s2.getSocietyId());

		//find all implemented
		List<CooperativeSociety>list = service.viewSocietyList();


		System.out.println("**** Details of Cooperative Society with Id :"+ s2.getSocietyId() + "****");
		System.out.println( "All Details Of Cooperative Society : " +list);
		System.out.println(s1);
		System.out.println(s1.getHeadOfSociety());
		System.out.println(s2.getDistrict());
	}
	


}
