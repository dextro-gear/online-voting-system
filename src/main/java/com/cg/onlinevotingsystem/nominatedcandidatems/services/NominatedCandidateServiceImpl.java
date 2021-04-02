package com.cg.onlinevotingsystem.nominatedcandidatems.services;

import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.InvalidCandidateException;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NominatedCandidateServiceImpl implements INominatedCandidatesService {

    @Autowired
    private INominatedCandidateRepository nominatedCandidateRepository;

    @Autowired
    private IRegisteredSocietyVotersService votersService;


    /**
     * This method stores the record of a NominatedCandidate object in the database.
     * @param candidate  The object which must be saved to the database
     * @return  The saved instance of the NominatedCandidate object
     */
    @Override
    public NominatedCandidates addNominatedCandidate(NominatedCandidates candidate) {
        validateCandidate(candidate);
        return nominatedCandidateRepository.save(candidate);
    }


    /**
     * This method updates the existing record of a NominatedCandidate object in the DB,
     * and throws an exception if the record doesn't exist.
     * @param candidateID  The ID of the candidate record which must be updated
     * @param nominationFormNo  The updated nomination form number
     * @param societyVoter  The updated society details
     * @return  The updated instance of the NominatedCandidate object.
     * @throws  CandidateNotFoundException
     */
    @Override
    public NominatedCandidates updateNominatedCandidateDetails(int candidateID, String nominationFormNo, RegisteredSocietyVoters societyVoter) {
        Optional<NominatedCandidates> candidatesOptional = nominatedCandidateRepository.findById(candidateID);
        NominatedCandidates candidate = candidatesOptional.get();
        if (!candidatesOptional.isPresent()) {
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " not found in the DB");
        }
        candidate.setNominationFormNo(nominationFormNo);
        votersService.updateRegisteredVoterDetails(societyVoter);
        return nominatedCandidateRepository.save(candidate);
    }


    /**
     * This method deletes an existing record of NominatedCandidate from the database,
     * and throws an exception if the record doesn't exist.
     * @param candidateID   The ID of the NominatedCandidate object which must be deleted
     * @return  The instance of the NominatedCandidate object which has been deleted
     * @throws  CandidateNotFoundException
     */
    @Override
    public NominatedCandidates deleteNominatedCandidate(int candidateID) {
        Optional<NominatedCandidates> candidatesOptional = nominatedCandidateRepository.findById(candidateID);
        if (!candidatesOptional.isPresent())
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " not found in the DB");

        nominatedCandidateRepository.delete(candidatesOptional.get());
        return candidatesOptional.get();
    }


    /**
     * This methods retrieves the record of a particular NominatedCandidate,
     * and throws an exception if the record doesn't exist.
     * @param candidateID   The ID of the NominatedCandidate whose record is to be retrieved
     * @return  The instance of the retrieved NominatedCandidate object
     * @throws  CandidateNotFoundException
     */
    @Override
    public NominatedCandidates searchByCandidateID(int candidateID) {
        Optional<NominatedCandidates> candidatesOptional = nominatedCandidateRepository.findById(candidateID);
        if (!candidatesOptional.isPresent())
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " not found in the DB");
        return candidatesOptional.get();
    }


    /**
     * This method retrieves all the records of NominatedCandidates in the database
     * @return  List of NominatedCandidate objects
     */
    @Override
    public List<NominatedCandidates> viewNominatedCandidateList() {
        return nominatedCandidateRepository.findAll();
    }


    /**
     * This method validates the candidate object passed to it,
     * and throws an exception if the object is invalid.
     * @param candidate  The object which has to be validate
     * @throws  InvalidCandidateException
     */
    void validateCandidate(NominatedCandidates  candidate){
        if(candidate==null){
            throw new InvalidCandidateException("arg can't be null");
        }
        if(candidate.getNominationFormNo()==null||candidate.getNominationFormNo().isEmpty()){
            throw new InvalidCandidateException("form nuo can't be null or empty");

        }
    }

}
