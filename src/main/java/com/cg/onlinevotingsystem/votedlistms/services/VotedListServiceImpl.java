package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.dao.VotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class VotedListServiceImpl implements VotedListService {

    @Autowired
    VotedListRepository votedListRepository;

    @Override
    public VotedList castVotedList(RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) {
        VotedList vote = new VotedList(voter, candidate, society);
        return votedListRepository.save(vote);
    }

    @Override
    // this method will update the detail in the record
    public VotedList updateVotedListDetails(int votedListID, RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) {
        return null;
    }

    @Override
    public VotedList deletedVotedListDetails(int id) {
        // find the VotedList
        // delete
        return null;
    }

    @Override
    public List<VotedList> viewVotedList() {
        return null;
    }


    @Override
    public VotedList searchByVoterId(int voterId) {
        return null;
    }

    @Override
    public List<VotedList> searchByNominatedCandidateId(int candidateId) {
        return null;
    }
}
