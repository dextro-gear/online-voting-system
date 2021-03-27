package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.votedlistms.dao.IVotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VotedListServiceImplTest {

    @Mock
    IVotedListRepository repository;

    @Spy
    @InjectMocks
    VotedListServiceImpl service;


   /* @Test
    void castVotedList() {
        VotedList votedList= Mockito.mock(VotedList.class);
        VotedList votedListSaved =Mockito.mock((VotedList.class));
        Mockito.when(repository.save(Mockito.any(VotedList.class))).thenReturn(votedListSaved);

        VotedList result=service.castVotedList(Mockito.mock(RegisteredSocietyVoters.class),
                Mockito.mock(NominatedCandidates.class),Mockito.mock(CooperativeSociety.class) );
       Assertions.assertNotNull(result);
        Assertions.assertEquals(votedListSaved,result);



    }
*/
   @Test
    void updateVotedListDetails() {
        VotedList votedList=Mockito.mock(VotedList.class);
        VotedList votedListSaved = Mockito.mock(VotedList.class);
       Mockito.when(repository.findById(123)).thenReturn(Optional.of(Mockito.mock(VotedList.class)));
       Mockito.when(repository.save(Mockito.any(VotedList.class))).thenReturn(votedListSaved);
       VotedList result = service.updateVotedListDetails(123,Mockito.mock(RegisteredSocietyVoters.class),
               Mockito.mock(NominatedCandidates.class),Mockito.mock(CooperativeSociety.class));
      // Assertions.assertNotNull(result);
       Assertions.assertEquals(votedListSaved,result);



    }

  /*  @Test
    void deletedVotedListDetails() {
        VotedList votedList = Mockito.mock(VotedList.class);
        VotedList votedListSaved = Mockito.mock(VotedList.class);
        Mockito.when(repository.findById(123)).thenReturn(Optional.of(Mockito.mock(VotedList.class)));
        VotedList result = service.deletedVotedListDetails(123);
        Assertions.assertEquals(votedList,result);

    }
*/
    @Test
    void viewVotedList() {

        VotedList votedList =Mockito.mock(VotedList.class);
        List<VotedList> list =new ArrayList<>();
        list.add(votedList);
        Mockito.when(repository.findAll()).thenReturn(list);
        List<VotedList> result =service.viewVotedList();
        Assertions.assertEquals(list,result);

    }

    @Test
    void searchByVoterId() {
        VotedList votedList =Mockito.mock(VotedList.class);
        Mockito.when(repository.findByVoter_Id(123)).thenReturn(votedList);
        VotedList result = service.searchByVoterId(123);
        Assertions.assertEquals(result,votedList);

    }

    @Test
    void searchByNominatedCandidateId() {
        VotedList votedList = Mockito.mock(VotedList.class);
        List<VotedList> list=new ArrayList<>();
        list.add(votedList);
        Mockito.when(repository.findByCandidate_CandidateID(123)).thenReturn(list);
       List<VotedList> result =service.searchByNominatedCandidateId(123);
       Assertions.assertEquals(list,result);


    }
}