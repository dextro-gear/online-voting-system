package com.cg.onlinevotingsystem.votedlistms.controller;

import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.services.IVotedListService;
import com.cg.onlinevotingsystem.votedlistms.util.VotedListUtil;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VotedListControllerUnitTest {

    @Mock
    IVotedListService votedListService;

    @Mock
    private CooperativeSocietyServiceImpl societyService;

    @Mock
    private RegisteredSocietyVotersServiceImpl votersService;

    @Mock
    private NominatedCandidateServiceImpl candidateService;

    @Mock
    VotedListUtil util;

    @Spy
    @InjectMocks
    VotedListController controller;


    @Test
    void castNewVote() {
    }

    @Test
    void viewVotedList() {
    }

    @Test
    void deleteVotedListDetails() {
    }

    @Test
    void searchByVoterId() {
    }
}