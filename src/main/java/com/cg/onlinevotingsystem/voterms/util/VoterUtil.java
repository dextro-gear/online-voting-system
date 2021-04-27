package com.cg.onlinevotingsystem.voterms.util;

import com.cg.onlinevotingsystem.voterms.dto.CreateVoterRequest;
import com.cg.onlinevotingsystem.voterms.dto.UpdateVoterRequest;
import com.cg.onlinevotingsystem.voterms.dto.VoterDetails;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.stereotype.Component;

@Component
public class VoterUtil {

    public RegisteredSocietyVoters populateVoterEntity(CreateVoterRequest request) {
        RegisteredSocietyVoters voter = new RegisteredSocietyVoters();
        voter.setFirstName(request.getFirstName());
        voter.setLastName(request.getLastName());
        voter.setEmailId(request.getEmailID());
        voter.setGender(request.getGender());
        voter.setPassword(request.getPassword());
        voter.setReservationCategory(request.getReservationCategory());
        voter.setMobileNo(request.getMobileNo());
        voter.setEmailId(request.getEmailID());
        voter.setAddress1(request.getAddress1());
        voter.setAddress2(request.getAddress2());
        voter.setMandal(request.getMandal());
        voter.setDistrict(request.getDistrict());
        voter.setPincode(request.getPincode());
        return voter;
    }

    public void populateVoterEntity(UpdateVoterRequest requestData, RegisteredSocietyVoters voter) {
        voter.setVoterIdCardNo(requestData.getVoterIDCardNo());
        voter.setFirstName(requestData.getFirstName());
        voter.setLastName(requestData.getLastName());
        voter.setGender(requestData.getGender());
        voter.setPassword(requestData.getPassword());
        voter.setReservationCategory(requestData.getReservationCategory());
        voter.setMobileNo(requestData.getMobileNo());
        voter.setEmailId(requestData.getEmailID());
        voter.setAddress1(requestData.getAddress1());
        voter.setAddress2(requestData.getAddress2());
        voter.setMandal(requestData.getMandal());
        voter.setDistrict(requestData.getDistrict());
        voter.setPincode(requestData.getPincode());
    }


    public VoterDetails details(RegisteredSocietyVoters registeredSocietyVoters) {
        VoterDetails vd = new VoterDetails();
        vd.setVoterIDCardNo(registeredSocietyVoters.getVoterIdCardNo());
        vd.setFirstName(registeredSocietyVoters.getFirstName());
        vd.setLastName(registeredSocietyVoters.getLastName());
        vd.setGender(registeredSocietyVoters.getGender());
        vd.setPassword(registeredSocietyVoters.getPassword());
        vd.setReservationCategory(registeredSocietyVoters.getReservationCategory());
        vd.setMobileNo(registeredSocietyVoters.getMobileNo());
        vd.setEmailID(registeredSocietyVoters.getEmailId());
        vd.setAddress1(registeredSocietyVoters.getAddress1());
        vd.setAddress2(registeredSocietyVoters.getAddress2());
        vd.setMandal(registeredSocietyVoters.getMandal());
        vd.setDistrict(registeredSocietyVoters.getDistrict());
        vd.setPincode(registeredSocietyVoters.getPincode());
        vd.setCooperativeSociety(registeredSocietyVoters.getSociety());
        vd.setCastedVote(registeredSocietyVoters.getCastedVote());
        return vd;
    }
}
