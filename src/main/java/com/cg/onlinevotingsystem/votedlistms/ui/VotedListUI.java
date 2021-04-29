package com.cg.onlinevotingsystem.votedlistms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.VotedListServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VotedListUI {

    @Autowired
    VotedListServiceImpl votedListService;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    public void start(){

        NominatedCandidates candidate1 = candidateService.searchByCandidateID(21);
        NominatedCandidates candidate2 = candidateService.searchByCandidateID(22);
        NominatedCandidates candidate3 = candidateService.searchByCandidateID(23);

        RegisteredSocietyVoters voter13 = votersService.searchByVoterID(13);
        RegisteredSocietyVoters voter14 = votersService.searchByVoterID(14);
        RegisteredSocietyVoters voter15 = votersService.searchByVoterID(15);
        RegisteredSocietyVoters voter16 = votersService.searchByVoterID(16);
        RegisteredSocietyVoters voter17 = votersService.searchByVoterID(17);
        RegisteredSocietyVoters voter18 = votersService.searchByVoterID(18);
        RegisteredSocietyVoters voter19 = votersService.searchByVoterID(19);

        VotedList castVotedList1 = votedListService.castVotedList(voter13, candidate1, voter13.getSociety());
        VotedList castVotedList2 = votedListService.castVotedList(voter14, candidate2, voter14.getSociety());
        VotedList castVotedList3 = votedListService.castVotedList(voter15, candidate3, voter15.getSociety());
        VotedList castVotedList4 = votedListService.castVotedList(voter16, candidate1, voter15.getSociety());
        VotedList castVotedList5 = votedListService.castVotedList(voter17, candidate2, voter15.getSociety());
        VotedList castVotedList6 = votedListService.castVotedList(voter18, candidate3, voter15.getSociety());
        VotedList castVotedList7 = votedListService.castVotedList(voter19, candidate1, voter15.getSociety());


    }

}
