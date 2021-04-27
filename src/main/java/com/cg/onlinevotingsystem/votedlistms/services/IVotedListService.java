package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import java.util.List;

public interface IVotedListService {

    VotedList castVotedList(RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society);

    VotedList updateVotedListDetails(int votedListID, RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society);

    VotedList deletedVotedListDetails(int id);

    List<VotedList> viewVotedList();

    VotedList searchByVoterId(int voterId);

    List<VotedList> searchByNominatedCandidateId(int candidateId);

    VotedList searchByVoterCardId(String cardId);
}
