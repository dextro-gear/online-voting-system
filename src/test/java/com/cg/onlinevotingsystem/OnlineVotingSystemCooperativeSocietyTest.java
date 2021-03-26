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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class OnlineVotingSystemCooperativeSocietyTest {
	
//	@InjectMocks
//	ICooperativeSocietyService service;
//	@Mock
//	ICooperativeSocietyDaoRepository repository;
//
//
//	@Test
//	public void AddSocietyDetailsTest(){
//		CooperativeSociety society1 = new CooperativeSociety(5,"mighin","milesha","surhi","gantantra","kahar","480808");
//		service.addSocietyDetails(society1);
//		verify(service,times(1)).addSocietyDetails(society1);
//
//	}
//
//
//	@Test
//	public void ViewSocietyByIDTest( ) {
//		when(repository.findById(1).get()).thenReturn(new CooperativeSociety(1,"hanal","viven","maliha","mahilaa","kunur","302608"));
//		CooperativeSociety s1 = service.viewSocietyById(1);
//		Assertions.assertEquals("hanal",s1.getSocietyName());
//		Assertions.assertEquals("viven",s1.getHeadOfSociety());
//		Assertions.assertEquals("maliha",s1.getVillage());
//		Assertions.assertEquals("mahila",s1.getMandal());
//	}
//	@Test
//	public void ViewSocietyListTest(){
//		List<CooperativeSociety> list = new ArrayList<CooperativeSociety>();
//		CooperativeSociety society1 = new CooperativeSociety(2,"migan","miesha","sursuri","gantantra","kahar","480608");
//		CooperativeSociety society2 = new CooperativeSociety(3,"Meraki","mahira","devgarh","janana","Kaman","610401");
//		list.add(society1);
//		list.add(society2);
//		when(service.viewSocietyList()).thenReturn(list);
//
//
//
//	}
//


}
