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
		CooperativeSociety s1 = service.addSocietyDetails( "Meraki", "Dev", "verumbakam","Mesur", "Teni", "111111");
		CooperativeSociety s2 = service.addSocietyDetails("Meluha", "Deviya", "minambakam","Meshur", "Aryalur", "222222");
		CooperativeSociety s3 = service.addSocietyDetails("Sandar", "Shiv", "karrembakam","Miniasi", "Erode", "333333");
		CooperativeSociety s4 = service.addSocietyDetails("Menaar", "Anika", "chanderi","Kaamna", "Jhansi", "444444");
		CooperativeSociety s5 = service.addSocietyDetails("Mugil", "Devraj", "basheera","Aakash", "Mirzapur", "555555");
		CooperativeSociety s6 = service.addSocietyDetails("Sikant", "Vijay", "chiniyam","Megham", "Amravati", "666666");
		CooperativeSociety s7 = service.addSocietyDetails("Vinayam", "Indra", "devgarh","Paripakta", "Chiyaan", "777777");
		CooperativeSociety s8 = service.addSocietyDetails("Maghil", "Mandana", "kovur","Damina", "Kohlapur", "888888");
		CooperativeSociety s9 = service.addSocietyDetails("Shakti", "Somnath", "kosuvampalayam","Soch", "Mulugu", "999999");
		CooperativeSociety s10 = service.addSocietyDetails("Muham", "Anish", "chandrapur","Dharti", "Erode", "101010");

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
