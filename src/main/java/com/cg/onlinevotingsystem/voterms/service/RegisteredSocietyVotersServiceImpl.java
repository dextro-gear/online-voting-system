package com.cg.onlinevotingsystem.voterms.service;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.dto.UpdateVoterRequest;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.exceptions.InvalidVoterException;
import com.cg.onlinevotingsystem.voterms.exceptions.VoterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegisteredSocietyVotersServiceImpl implements IRegisteredSocietyVotersService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private CooperativeSocietyServiceImpl societyService;


    @Override
    @Transactional
    public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {
        validateVoter(voter);
        String cardId=generateId();
        voter.setVoterIdCardNo(cardId);
        return voterRepository.save(voter);
    }

    public String generateId(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<10;i++){
            int randomNum=random.nextInt(10);
            builder.append(randomNum);
        }
        return builder.toString();

    }

    @Override
    @Transactional
    public RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter) {
        validateVoter(voter);
        boolean exists = voterRepository.existsById(voter.getId());
        if (!exists) {
            throw new VoterNotFoundException("Voter with id:" + voter.getId() + " was not found in the DB");
        }
        return voterRepository.save(voter);
    }


    @Override
    @Transactional
    public RegisteredSocietyVoters deleteRegisteredVoter(int voterId) {
        RegisteredSocietyVoters voter = searchByVoterID(voterId);
        voterRepository.deleteById(voterId);
        return voter;
    }

    @Override
    public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
        return voterRepository.findAll();
    }

    @Override
    public RegisteredSocietyVoters searchByVoterID(int voterId) {
        Optional<RegisteredSocietyVoters> registeredSocietyVotersOptional = voterRepository.findById(voterId);
        if (registeredSocietyVotersOptional.isPresent()) {
            return registeredSocietyVotersOptional.get();
        }

        throw new VoterNotFoundException("Voter with id:" + voterId + " was not found in the DB");
    }

    @Override
    public RegisteredSocietyVoters loginValidate(String userid, String password) {
        return null;
    }


    public void validateFirstName(RegisteredSocietyVoters voter) {
        if (voter.getFirstName() == null || voter.getFirstName().isEmpty()) {
            throw new InvalidVoterException(" firstName can't null or empty");
        }
    }

    public void validateVoter(RegisteredSocietyVoters voter) {
        if(voter==null){
            throw new InvalidVoterException("voter arg can't be null");
        }
        validateFirstName(voter);
    }

}