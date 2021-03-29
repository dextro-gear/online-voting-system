package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.dao.IVotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.exceptions.VotedListNotFoundException;
import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VotedListServiceImpl implements IVotedListService {

    @Autowired
    IVotedListRepository votedListRepository;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    @Override
    public VotedList castVotedList(RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) {
        VotedList vote = new VotedList(voter, candidate, society);
        societyService.addSocietyDetails(society);
        votersService.voterRegistration(voter);
        candidateService.addNominatedCandidate(candidate);
        return votedListRepository.save(vote);
    }

    @Override
    // this method will update the detail in the record
    public VotedList updateVotedListDetails(int votedListID, RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) {
        Optional<VotedList> votedListOptional = votedListRepository.findById(votedListID);
       if (votedListOptional.isPresent())
       {
          VotedList vote=votedListOptional.get();
          vote.setVoter(voter);
          vote.setCandidate(candidate);
          vote.setSociety(society);
          return votedListRepository.save(vote);
       }
       else
           throw new VotedListNotFoundException("VotedList with id:" + votedListID + " was not found in the DB");

    }

    @Override
    public VotedList deletedVotedListDetails(int id) {
        Optional<VotedList> votedListOptional = votedListRepository.findById(id);
        if (votedListOptional.isPresent()) {
            votedListRepository.delete(votedListOptional.get());
            return votedListOptional.get();
        } else
            throw new VotedListNotFoundException("VotedList with id:" + id + " was not found in the DB");
    }

    @Override
    public List<VotedList> viewVotedList() {
        return votedListRepository.findAll();
    }

    @Override
    public VotedList searchByVoterId(int voterId) {
        Optional<VotedList> votedListOptional = Optional.of(votedListRepository.findByVoter_Id(voterId));
        if (votedListOptional.isPresent())
            return votedListOptional.get();
        else
            throw new VotedListNotFoundException("VotedList record with voter:" + voterId + " was not found in the DB");
    }

    @Override
    public List<VotedList> searchByNominatedCandidateId(int candidateId) {
        List<VotedList> votes = votedListRepository.findByCandidate_CandidateID(candidateId);
        if (votes.size() > 0)
            return votes;
        else
            throw new VotedListNotFoundException("VotedList records for Candidate:" + candidateId + " were not found in the DB");

    }
}
