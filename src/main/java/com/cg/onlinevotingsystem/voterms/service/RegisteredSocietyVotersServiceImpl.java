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

    /**
     * This method creates a new record for a voter in the database.
     * @param voter The voter which has multiple fields of general information
     * @return the newly created voter entity object
     */
    @Override
    @Transactional
    public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter) {
        validateVoter(voter);
        String cardId=generateId();
        boolean generateLoop = true;
        while(generateLoop){
            try {
                findByVoterCardId(cardId);
            } catch (VoterNotFoundException e) {
                generateLoop = false;
            }
        }
        voter.setVoterIdCardNo(cardId);
        return voterRepository.save(voter);
    }

    /**
     * This method is to generate a random Id to the voter ranging from 0-9.
     * @return a randomly generated Id for voter in string format.
     */
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
    public RegisteredSocietyVoters findByVoterCardId(String cardId){
        boolean exists=voterRepository.existsByVoterIDCardNo(cardId);
        if(!exists){
            throw new VoterNotFoundException("voter not found for card id="+cardId);
        }
        RegisteredSocietyVoters voter=voterRepository.findRegisteredSocietyVotersByVoterIDCardNo(cardId);
        return voter;
    }

    /**
     * This method updates all the field of voter information in the database.
     * @param voter The voter which has multiple fields of general information
     * @return The updated values on information field of voter.
     */
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


    /**
     * This methods the row from the database on the basis of Id of the voter.
     * @param voterId The self generated Id .
     * @return The remaining objects in the database.
     */
    @Override
    @Transactional
    public RegisteredSocietyVoters deleteRegisteredVoter(int voterId) {
        RegisteredSocietyVoters voter = searchByVoterID(voterId);
        voterRepository.deleteById(voterId);
        return voter;
    }


    /**
     * This method returns the record of all the voters registered till date.
     * @return Returns the Registered society voters objects.
     */
    @Override
    public List<RegisteredSocietyVoters> viewRegisteredVoterList() {
        return voterRepository.findAll();
    }


    /**
     * This method searches the database for voter based on voterId.
     * @param voterId The self generated Id for voter
     * @return Returns the Registered society voter object if found by id
     * else throws an exception of voter not found
     */
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

    /**
     * This method validates the first name for it to be not null or empty.
     * @param voter The voter object which has multiple fields of general information
     */

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