package com.cg.onlinevotingsystem.cooperativesocietyms.dao;

import java.util.List;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICooperativeSocietyDaoRepository extends JpaRepository {
	
	int addSocietyDetails(CooperativeSociety society);
	int updateSocietyDetails(CooperativeSociety society);
	int deleteSociety(int societyId);
	List<CooperativeSociety>viewSocietyList();
	CooperativeSociety viewSocietyById();
	

}
