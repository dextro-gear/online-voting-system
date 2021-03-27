package com.cg.onlinevotingsystem.nominatedcandidatems.services;

import com.cg.onlinevotingsystem.dashboard.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class NominatedCandidateServiceImpl implements INominatedCandidatesService{

    @Autowired
    INominatedCandidateRepository nominatedCandidateRepository;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    @Override
    @Transactional
    public NominatedCandidates addNominatedCandidate(String nominationFormNo, RegisteredSocietyVoters societyVoter) {
        votersService.voterRegistration(societyVoter);
        return nominatedCandidateRepository.save(new NominatedCandidates(nominationFormNo, societyVoter));
    }

    @Override
    @Transactional
    public NominatedCandidates addNominatedCandidate(NominatedCandidates candidate){
        votersService.voterRegistration(candidate.getSocietyVoter());
        return nominatedCandidateRepository.save(candidate);
    }

    @Override
    @Transactional
    public NominatedCandidates updateNominatedCandidateDetails(int id, String nominationFormNo, RegisteredSocietyVoters societyVoter) {
        Optional<NominatedCandidates> candidatesOptional = nominatedCandidateRepository.findById(id);
        NominatedCandidates candidate = candidatesOptional.get();
        if(candidatesOptional.isPresent()){
            candidate.setNominationFormNo(nominationFormNo);
            candidate.setSocietyVoter(societyVoter);
        } else
            throw new CandidateNotFoundException("Candidate with id" + id + " not found in the DB");

        return nominatedCandidateRepository.save(candidate);
    }

    @Override
    public NominatedCandidates deleteNominatedCandidate(int candidateID) {
        Optional<NominatedCandidates> candidatesOptional = nominatedCandidateRepository.findById(candidateID);
        if(!candidatesOptional.isPresent())
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " not found in the DB");
        else
            nominatedCandidateRepository.delete(candidatesOptional.get());
        return candidatesOptional.get();
    }

    @Override
    public NominatedCandidates searchByCandidateID(int candidateID) {
        Optional<NominatedCandidates> candidatesOptional = nominatedCandidateRepository.findById(candidateID);
        if(!candidatesOptional.isPresent())
            throw new CandidateNotFoundException("Candidate with id" + candidateID + " not found in the DB");
        return candidatesOptional.get();
    }

    @Override
    public List<NominatedCandidates> viewNominatedCandidateList() {
        return nominatedCandidateRepository.findAll();
    }
}
