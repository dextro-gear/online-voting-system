package com.cg.onlinevotingsystem.cooperativesocietyms.dao;

import java.util.List;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICooperativeSocietyDaoRepository extends JpaRepository<CooperativeSociety,Integer> {
	
	CooperativeSociety addSocietyDetails(CooperativeSociety society);
	CooperativeSociety updateSocietyDetails(CooperativeSociety society);
	CooperativeSociety deleteSociety(int societyId);
	List<CooperativeSociety>viewSocietyList();
	CooperativeSociety viewSocietyById();
	

}
