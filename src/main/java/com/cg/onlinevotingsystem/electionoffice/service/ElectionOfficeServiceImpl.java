package com.cg.onlinevotingsystem.electionoffice.service;

import com.cg.onlinevotingsystem.electionoffice.dao.IElectionOfficeRepository;
import com.cg.onlinevotingsystem.electionoffice.entities.ElectionOfficer;
import com.cg.onlinevotingsystem.electionoffice.exceptions.ElectionOfficerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionOfficeServiceImpl implements IElectionOfficeService{

    @Autowired
    private IElectionOfficeRepository officeRepository;

    @Override
    public ElectionOfficer addElectionOfficer(ElectionOfficer officer) {
        return officeRepository.save(officer);
    }


    @Override
    public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer) {
        return officeRepository.save(officer);
    }


    @Override
    public ElectionOfficer deleteElectionOfficer(int officerID) {
        Optional<ElectionOfficer> officerOptional = officeRepository.findById(officerID);
        if(!officerOptional.isPresent())
            throw new ElectionOfficerNotFoundException("Election Officer with id:" + officerID + " was not found in the DB");

        officeRepository.delete(officerOptional.get());
        return officerOptional.get();
    }

    @Override
    public ElectionOfficer viewElectionOfficerByID(int officerID) {
        Optional<ElectionOfficer> officerOptional = officeRepository.findById(officerID);
        if(!officerOptional.isPresent())
            throw new ElectionOfficerNotFoundException("Election Officer with id:" + officerID + " was not found in the DB");
        return officerOptional.get();
    }

    @Override
    public List<ElectionOfficer> viewElectionOfficersList() {
        return officeRepository.findAll();
    }
}
