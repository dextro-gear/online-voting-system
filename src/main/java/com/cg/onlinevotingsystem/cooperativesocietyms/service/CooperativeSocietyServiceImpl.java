package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CooperativeSocietyServiceImpl implements ICooperativeSocietyService{
    @Autowired
    ICooperativeSocietyDaoRepository cooperativeSocietyRepository;


    @Override
    public CooperativeSociety addSocietyDetails(CooperativeSociety society) {
           CooperativeSociety s1 = new CooperativeSociety();
           return cooperativeSocietyRepository.save(s1) ;
    }

    @Override
    public CooperativeSociety updateSocietyDetails(CooperativeSociety society) {
        CooperativeSociety s1 = new CooperativeSociety();
        s1.setSocietyId(society.getSocietyId());
        return cooperativeSocietyRepository.save(s1);
    }

    @Override
    public CooperativeSociety deleteSociety(int societyId) {
        Optional<CooperativeSociety> cooperativeSocietyOptional = this.cooperativeSocietyRepository.findById(societyId);
        if(cooperativeSocietyOptional.isPresent())
            cooperativeSocietyRepository.delete(cooperativeSocietyOptional.get());
        return cooperativeSocietyOptional.get();
    }

    @Override
    public List<CooperativeSociety> viewSocietyList() {
        return this.cooperativeSocietyRepository.findAll();
    }

    @Override
    public CooperativeSociety viewSocietyById(int societyId) {
        Optional<CooperativeSociety> cooperativeSocietyOptional = this.cooperativeSocietyRepository.findById(societyId);
        if (cooperativeSocietyOptional.isPresent())
            return cooperativeSocietyOptional.get() ;
        else
            return null;
    }

}
