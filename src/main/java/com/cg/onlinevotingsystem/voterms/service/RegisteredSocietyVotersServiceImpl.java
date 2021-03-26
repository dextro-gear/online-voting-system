package com.cg.onlinevotingsystem.voterms.service;


import java.util.List;
import java.util.Optional;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredSocietyVotersServiceImpl implements IRegisteredSocietyVotersService {

    @Autowired
    VoterRepository voterRepository;

    @Override
    public RegisteredSocietyVoters voterRegistration(String voterIdCardNo,String firstName, String lastName, String gender, String password, String reservationCategory,
                                                     String mobileNo, String emailId, String address1, String address2, String mandal, String district, int pincode, CooperativeSociety society,
                                                     boolean castedVote) {
        //this method will return the information about the voter
        RegisteredSocietyVoters t1 = new RegisteredSocietyVoters();



        return null; }

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
        //This method will delete the voter in argument
        Optional<RegisteredSocietyVoters> registeredSocietyVotersOptional = voterRepository.findById(voterId);
        if (registeredSocietyVotersOptional.isPresent()) {
            voterRepository.delete(registeredSocietyVotersOptional.get());
        }

        return registeredSocietyVotersOptional.get();
    }

    @Override
    public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
        return this.voterRepository.findAll();
    }

    @Override
    public RegisteredSocietyVoters searchByVoterID(int voterId) {
        Optional<RegisteredSocietyVoters> registeredSocietyVotersOptional = this.voterRepository.findById(voterId);
        if (registeredSocietyVotersOptional.isPresent()){
            return registeredSocietyVotersOptional.get();
        }
        else
            return null;
    }

    @Override
    public RegisteredSocietyVoters loginValidate(String userid, String password) {
        return null;
    }


}
