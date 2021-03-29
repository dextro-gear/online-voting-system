package com.cg.onlinevotingsystem.voterms.service;


import java.util.List;
import java.util.Optional;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.exceptions.RegisteredSocietyVoterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredSocietyVotersServiceImpl implements IRegisteredSocietyVotersService {

    @Autowired
    VoterRepository voterRepository;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    @Override
    public RegisteredSocietyVoters voterRegistration(String voterIdCardNo,String firstName, String lastName, String gender, String password, String reservationCategory, String mobileNo, String emailId, String address1, String address2, String mandal, String district, int pincode, boolean castedVote, CooperativeSociety society) {
        RegisteredSocietyVoters t1 = new RegisteredSocietyVoters(voterIdCardNo, firstName, lastName, gender, password, reservationCategory, mobileNo,emailId, address1, address2,mandal, district,pincode, castedVote, society);
        societyService.addSocietyDetails(society);
        return voterRepository.save(t1);
    }

    @Override
    public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter){
        societyService.addSocietyDetails(voter.getSociety());
        return voterRepository.save(voter);
    }

    @Override
    public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {

        Optional<RegisteredSocietyVoters> registeredSocietyVotersOptional = voterRepository.findById(voter.getId());
        if (registeredSocietyVotersOptional.isPresent()) {
            RegisteredSocietyVoters t1 = registeredSocietyVotersOptional.get();
            t1.setVoterIdCardNo(voter.getVoterIdCardNo());
            t1.setFirstName(voter.getFirstName());
            t1.setLastName(voter.getLastName());
            t1.setGender(voter.getGender());
            t1.setPassword(voter.getPassword());
            t1.setReservationCategory(voter.getReservationCategory());
            t1.setMobileNo(voter.getMobileNo());
            t1.setEmailId(voter.getEmailId());
            t1.setAddress1(voter.getAddress1());
            t1.setAddress2(voter.getAddress2());
            t1.setMandal(voter.getMandal());
            t1.setDistrict(voter.getDistrict());
            t1.setPincode(voter.getPincode());
            t1.setSociety(voter.getSociety());
            t1.setCastedVote(voter.getCastedVote());
            return voterRepository.save(t1);
        }
        return registeredSocietyVotersOptional.get();
    }

    @Override
    public RegisteredSocietyVoters deleteRegisteredVoter(int voterId) {
        Optional<RegisteredSocietyVoters> registeredSocietyVotersOptional = voterRepository.findById(voterId);
        if (registeredSocietyVotersOptional.isPresent()) {
            voterRepository.delete(registeredSocietyVotersOptional.get());
        }
        else
            throw new RegisteredSocietyVoterNotFoundException("Voter with id:" + voterId + " was not found in the DB");

        return registeredSocietyVotersOptional.get();
    }

    @Override
    public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
        return voterRepository.findAll();
    }

    @Override
    public RegisteredSocietyVoters searchByVoterID(int voterId) {
        Optional<RegisteredSocietyVoters> registeredSocietyVotersOptional = voterRepository.findById(voterId);
        if (registeredSocietyVotersOptional.isPresent()){
            return registeredSocietyVotersOptional.get();
        }
        else
            throw new RegisteredSocietyVoterNotFoundException("Voter with id:" + voterId + " was not found in the DB");
    }

    @Override
    public RegisteredSocietyVoters loginValidate(String userid, String password) {
        return null;
    }


}