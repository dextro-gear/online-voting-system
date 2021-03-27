package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import java.util.List;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;

public interface ICooperativeSocietyService {

	CooperativeSociety addSocietyDetails(CooperativeSociety society);
	CooperativeSociety addSocietyDetails( String societyName, String headOfSociety, String village, String mandal,
										  String district, String pincode);
	CooperativeSociety updateSocietyDetails(int societyId ,String societyName, String headOfSociety, String village, String mandal,
											 String district, String pincode);
	CooperativeSociety deleteSociety(int societyId);
	List<CooperativeSociety>viewSocietyList();
	CooperativeSociety viewSocietyById(int societyId);
	
}
