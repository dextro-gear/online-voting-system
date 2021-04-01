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
    IElectionOfficeRepository officeRepository;

    @Override
    public ElectionOfficer addElectionOfficer(ElectionOfficer officer) {
        return officeRepository.save(officer);
    }

    @Override
    public ElectionOfficer addElectionOfficer(String firstName, String lastName, String password, String gender, String mobileNo, String emailID, String address1, String address2, String district) {
        return officeRepository.save(new ElectionOfficer()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setGender(gender)
                .setMobileNo(mobileNo)
                .setEmailID(emailID)
                .setAddress1(address1)
                .setAddress2(address2)
                .setDistrict(district)
        );
    }

    @Override
    public ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer) {
        return officeRepository.save(officer);
    }

    @Override
    public ElectionOfficer updateElectionOfficerDetails(int officerID, String firstName, String lastName, String password, String gender, String mobileNo, String emailID, String address1, String address2, String district) {
        Optional<ElectionOfficer> officerOptional = officeRepository.findById(officerID);
        if(!officerOptional.isPresent())
            throw new ElectionOfficerNotFoundException("Election Officer with id:" + officerID + " was not found in the DB");

        return officeRepository.save(officerOptional.get()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setGender(gender)
                .setMobileNo(mobileNo)
                .setEmailID(emailID)
                .setAddress1(address1)
                .setAddress2(address2)
                .setDistrict(district)
        );
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
