package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import java.util.List;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;

public interface ICooperativeSocietyService {
	int addSocietyDetails(CooperativeSociety society);
	int updateSocietyDetails(CooperativeSociety society);
	int deleteSociety(int societyId);
	List<CooperativeSociety>viewSocietyList();
	CooperativeSociety viewSocietyById(int societyId);
	
}
