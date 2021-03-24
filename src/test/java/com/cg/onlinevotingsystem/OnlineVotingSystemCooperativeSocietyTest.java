package com.cg.onlinevotingsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;

@SpringBootTest
class OnlineVotingSystemCooperativeSocietyTest {
	
	@Autowired

	
	@Test
	public void ViewSocietyByID( ) {
		CooperativeSociety s1 =new CooperativeSociety() ;
		s1.setSocietyId(1);
		s1.setHeadOfSociety("Divena");
		s1.setSocietyName("Meraki");
		s1.setMandal("Jeevani");
		s1.setVillage("Teni");
		s1.setPincode("603203");
		s1.setDistrict("keni");
		

		
		 
		
		Assertions.assertEquals(1,s1.getSocietyId() );
		Assertions.assertEquals("Divena",s1.getHeadOfSociety())	;
		

	}
	@Test
	public void ViewSocietyList(){
		CooperativeSociety society1 = new CooperativeSociety(1,"migan","miesha","sursuri","gantantra","kahar","480608");
		CooperativeSociety society2 = new CooperativeSociety(2,"Meraki","mahira","devgarh","janana","Kaman","610401");


	}

}
