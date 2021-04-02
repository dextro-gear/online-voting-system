package com.cg.onlinevotingsystem.votedlistms.controller;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.votedlistms.dto.CastVotedListRequest;
import com.cg.onlinevotingsystem.votedlistms.dto.CastVotedListResponse;
import com.cg.onlinevotingsystem.votedlistms.dto.VotedListDTO;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.IVotedListService;
import com.cg.onlinevotingsystem.votedlistms.util.VotedListUtil;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
    VotedListController votedListController;



    @Test
    void viewVotedList() {

        List<VotedList> votedListList = mock(List.class);
        when(votedListService.viewVotedList()).thenReturn(votedListList);
        List<VotedListDTO> requiredList = mock(List.class);
        when(util.toDTO(votedListList)).thenReturn(requiredList);
        List<VotedListDTO> result = votedListController.viewVotedList();
        assertNotNull(result);
        assertSame(requiredList,result);
        verify(votedListService).viewVotedList();
        verify(util).toDTO(votedListList);

    }

    @Test
    void deleteVotedListDetails() {

        int id =5;
        VotedList votedList=mock(VotedList.class);
        VotedListDTO votedListDTO=mock(VotedListDTO.class);
        when(votedListService.deletedVotedListDetails(id)).thenReturn(votedList);
        when(util.toDTO(votedList)).thenReturn(votedListDTO);
        votedListController.deleteVotedListDetails(id);
        verify(votedListService).deletedVotedListDetails(id);
        verify(util).toDTO(votedList);
    }

    @Test
    void searchByVoterId() {
        int id =5;
        VotedList votedList = mock(VotedList.class);
        VotedListDTO votedListDTO=mock(VotedListDTO.class);
        when(votedListService.searchByVoterId(id)).thenReturn(votedList);
        when(util.toDTO(votedList)).thenReturn(votedListDTO);
        VotedListDTO result = votedListController.searchByVoterId(id);
        assertSame(votedListDTO,result);
        verify(votedListService).searchByVoterId(id);
        verify(util).toDTO(votedList);

    }
}