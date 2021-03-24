package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import java.util.List;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CooperativeSocietyServiceImpl implements ICooperativeSocietyService {
	@Autowired
	ICooperativeSocietyDaoRepository repository;

	@Override
	public int addSocietyDetails(CooperativeSociety society) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSocietyDetails(CooperativeSociety society) {

		return 0;
	}

	@Override
	public int deleteSociety(int societyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CooperativeSociety> viewSocietyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CooperativeSociety viewSocietyById(int societyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
