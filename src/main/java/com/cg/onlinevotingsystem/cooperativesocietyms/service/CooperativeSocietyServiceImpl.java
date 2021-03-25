package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CooperativeSocietyServiceImpl implements ICooperativeSocietyService{
    @Autowired
    ICooperativeSocietyDaoRepository repository;


    @Override
    public CooperativeSociety addSocietyDetails(CooperativeSociety society) {
        return null;
    }

    @Override
    public CooperativeSociety updateSocietyDetails(CooperativeSociety society) {
        CooperativeSociety s1 = new CooperativeSociety();
        return repository.save(s1);
    }

    @Override
    public CooperativeSociety deleteSociety(CooperativeSociety societyId) {
        return null;
    }

    @Override
    public List<CooperativeSociety> viewSocietyList() {
        return null;
    }

    @Override
    public CooperativeSociety viewSocietyById(int societyId) {
        return null;
    }

}
