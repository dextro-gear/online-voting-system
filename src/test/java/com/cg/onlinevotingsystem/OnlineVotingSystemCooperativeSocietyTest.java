package com.cg.onlinevotingsystem;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class OnlineVotingSystemCooperativeSocietyTest {
	
	@InjectMocks
	ICooperativeSocietyService service;
	@Mock
	ICooperativeSocietyDaoRepository repository;

	
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
	public void ViewSocietyListTest(){
		CooperativeSociety society1 = new CooperativeSociety(1,"migan","miesha","sursuri","gantantra","kahar","480608");
		CooperativeSociety society2 = new CooperativeSociety(2,"Meraki","mahira","devgarh","janana","Kaman","610401");



	}
	@Test
	public void AddSocietyDetailsTest(){
		CooperativeSociety society1 = new CooperativeSociety(5,"mighin","milesha","surhi","gantantra","kahar","480808");
        service.addSocietyDetails(society1);
        verify(repository,times(1)).addSocietyDetails(society1);

	}

}
