package com.cg.onlinevotingsystem;

import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;

@SpringBootTest
class OnlineVotingSystemCooperativeSocietyTest {
	
	@Autowired
	 ICooperativeSocietyService service;
	@MockBean
	ICooperativeSocietyRepository repository;
	
	@Test
	public void ViewSocietyListTest( ) {
		CooperativeSociety s1 =new CooperativeSociety() ;
		s1.setSocietyId(1);
		s1.setHeadOfSociety("Divena");
		s1.setSocietyName("Meraki");
		s1.setMandal("Jeevani");
		s1.setVillage("Teni");
		s1.setPincode("603203");
		s1.setDistrict("keni");
		
		s1 = service.viewSocietyById(1);
		
		 
		
		Assertions.assertEquals(1,s1.getSocietyId() );
		Assertions.assertEquals("Divena",s1.getHeadOfSociety())	;
		

	}

}
