package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.votedlistms.dao.IVotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VotedListServiceImplTest {

    @Mock
    IVotedListRepository repository;

    @Spy
    @InjectMocks
    VotedListServiceImpl service;


    @Test
    void castVotedList() {
        VotedList votedList= Mockito.mock(VotedList.class);
        VotedList votedListSaved =Mockito.mock((VotedList.class));
        Mockito.when(repository.save(Mockito.any(VotedList.class))).thenReturn(votedListSaved);

        VotedList result=service.castVotedList(Mockito.mock(RegisteredSocietyVoters.class),
                Mockito.mock(NominatedCandidates.class),Mockito.mock(CooperativeSociety.class) );
      //gradlew test  Assertions.assertNotNull(result);
        Assertions.assertEquals(votedListSaved,result);



    }

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

    @Test
    void deletedVotedListDetails() {
    }

    @Test
    void viewVotedList() {

    }

    @Test
    void searchByVoterId() {
    }

    @Test
    void searchByNominatedCandidateId() {
    }
}