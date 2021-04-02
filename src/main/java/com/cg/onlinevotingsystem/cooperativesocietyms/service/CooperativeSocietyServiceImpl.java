package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.exceptions.SocietyNotFoundException;
import com.cg.onlinevotingsystem.cooperativesocietyms.exceptions.InvalidSocietyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CooperativeSocietyServiceImpl implements ICooperativeSocietyService {

    @Autowired
    private ICooperativeSocietyDaoRepository cooperativeSocietyRepository;


    /**
     * This method saves a CooperativeSociety record in the database.
     * @param society  The object of CooperativeSociety which must be saved
     * @return  The saved instance of the CooperativeSociety object
     */
    @Override
    public CooperativeSociety addSocietyDetails(CooperativeSociety society) {
        validateSociety(society);
        return cooperativeSocietyRepository.save(society);
    }


    /**
     * This methods updates an existing CooperativeSociety record in the database,
     * and throws an exception if the record doesn't exist.
     * @param society  The CooperativeSociety object with the updated details
     * @return  The saved instance of the CooperativeSociety object
     * @throws  SocietyNotFoundException
     */
    @Override
    public CooperativeSociety updateSociety(CooperativeSociety society) {
        validateSociety(society);
        boolean exists = cooperativeSocietyRepository.existsById(society.getSocietyId());
        if(!exists){
            throw new SocietyNotFoundException("society not found for id="+society.getSocietyId());
        }
        return cooperativeSocietyRepository.save(society);
    }


    /**
     * This method deletes an existing CooperativeSociety record from the database,
     * and throws an exception id the record does not exist.
     * @param societyId  The ID of the record which must be deleted
     * @return  The instance of the object which has been deleted
     * @throws SocietyNotFoundException
     */
    @Override
    public CooperativeSociety deleteSociety(int societyId) {
        Optional<CooperativeSociety> cooperativeSocietyOptional = cooperativeSocietyRepository.findById(societyId);
        if (!cooperativeSocietyOptional.isPresent()) {
            throw new SocietyNotFoundException("CooperativeSociety with id:" + societyId + " was not found in the DB");
        }
        cooperativeSocietyRepository.delete(cooperativeSocietyOptional.get());
        return cooperativeSocietyOptional.get();
    }


    /**
     * This method retrieves all the records of CooperativeSociety in the database
     * @return  A List of CooperativeSociety objects
     */
    @Override
    public List<CooperativeSociety> viewSocietyList() {
        return cooperativeSocietyRepository.findAll();
    }


    /**
     * This method returns the record of a particular CooperativeSociety object.
     * Throws an exception if the record doesn't exist.
     * @param societyId  The ID of the record which has to be retrieved
     * @return  An instance of CooperativeSociety object which has been retrieved from the DB
     * @throws SocietyNotFoundException
     */
    @Override
    public CooperativeSociety viewSocietyById(int societyId) {
        Optional<CooperativeSociety> cooperativeSocietyOptional = cooperativeSocietyRepository.findById(societyId);
        if (cooperativeSocietyOptional.isPresent()) {
            return cooperativeSocietyOptional.get();
        }

        throw new SocietyNotFoundException("CooperativeSociety with id:" + societyId + " was not found in the DB");
    }


    /**
     * This method validates the name of the CooperativeSociety object.
     * It throws an exception if the input name is invalid.
     * @param name  The name of the CooperativeSociety object
     * @throws InvalidSocietyException
     */
    void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidSocietyException("Name cannot be null or empty");
        }
    }


    /**
     * This method validates the CooperativeSociety object.
     * It throws an exception if the input is invalid.
     * @param society The CooperativeSociety object
     * @throws InvalidSocietyException
     */
    void validateSociety(CooperativeSociety society) {
        if (society == null) {
            throw new InvalidSocietyException("Society object cannot be null");
        }
        validateName(society.getSocietyName());
    }

}
