package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.votedlistms.dao.IVotedListRepository;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.exceptions.InvalidVoteException;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class VotedListServiceImplTest {

    @Mock
    IVotedListRepository voteRepository;

    @Mock
    IRegisteredSocietyVotersService votersService;

    @Spy
    @InjectMocks
    VotedListServiceImpl service;


    /**
     * scenario: vote added successfully
     * input : mock voter, candidate, society
     * expectation: verifying verify(voteRepository).save(vote) is called
     */
    @Test
    void testCastVotedList_1() {
       VotedList vote = mock(VotedList.class);
        VotedList voteSaved =mock((VotedList.class));
        when(voteRepository.save(vote)).thenReturn(voteSaved);
        RegisteredSocietyVoters voter=mock(RegisteredSocietyVoters.class);
        NominatedCandidates candidate=mock(NominatedCandidates.class);
        CooperativeSociety society=mock(CooperativeSociety.class);
        LocalDateTime dateTime=LocalDateTime.now();
        doReturn(dateTime).when(service).currentDate();
        doReturn(vote).when(service).newVote(voter,candidate,society);
        VotedList result = service.castVotedList(voter,candidate,society);
        Assertions.assertNotNull(result);
        verify(voteRepository).save(vote);
        verify(voter).setCastedVote(true);
        verify(votersService).updateRegisteredVoterDetails(voter);

    }

    /**
     * scenario: vote NOT added successfully, validation fails
     * input : mock voter, candidate, society
     * expectation: InvalidVoteException is thrown
     */
    @Test
    void testCastVotedList_2() {
        RegisteredSocietyVoters voter=mock(RegisteredSocietyVoters.class);
        NominatedCandidates candidate=mock(NominatedCandidates.class);
        CooperativeSociety society=mock(CooperativeSociety.class);
        doThrow(InvalidVoteException.class).when(service).validateVote(voter,candidate,society);
        Executable executable=()->service.castVotedList(voter,candidate,society);
        Assertions.assertThrows(InvalidVoteException.class ,executable);
    }

    /**
     * scenario: votes are updated successfully
     * input : voteId ,mock voter, candidate, society
     * expectation: verifying verify(voteRepository).save(vote) is called
     */
    @Test
    void testUpdateVotedListDetails() {
        RegisteredSocietyVoters voter=mock(RegisteredSocietyVoters.class);
        NominatedCandidates candidate=mock(NominatedCandidates.class);
        CooperativeSociety society=mock(CooperativeSociety.class);
        int voteId=89;
        doNothing().when(service).validateVote(voter,candidate,society);
        VotedList vote=mock(VotedList.class);
        Optional<VotedList>optional=Optional.of(vote);
        when(voteRepository.findById(voteId)).thenReturn(optional);
        when(voteRepository.save(vote)).thenReturn(vote);
        VotedList result = service.updateVotedListDetails(voteId,voter,candidate,society);
        Assertions.assertSame(vote,result);
        verify(vote).setVoter(voter);
        verify(vote).setCandidate(candidate);
        verify(vote).setSociety(society);
        verify(voteRepository).save(vote);

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


    /**
     * scenario:  list of votes is successfully viewed
     * input : mocked votedlist  object
     * expectation: voteRepository.findByVoter_Id(voterid) is called
     */
    @Test
    void viewVotedList() {

        VotedList votedList =mock(VotedList.class);
        List<VotedList> list = new ArrayList<>();
        list.add(votedList);
        when(voteRepository.findAll()).thenReturn(list);
        List<VotedList> result = service.viewVotedList();
        Assertions.assertEquals(list, result);

    }


    /**
     * scenario:  vote of particular voter is successfully viewed
     * input : mocked votedlist  object
     * expectation: voteRepository.findByVoter_Id(voterid) is called and vote is successfully viewed
     */
    @Test
    void searchByVoterId() {
        VotedList votedList =mock(VotedList.class);
        when(voteRepository.findByVoter_Id(123)).thenReturn(votedList);
        VotedList result = service.searchByVoterId(123);
        Assertions.assertEquals(result, votedList);

    }


    /**
     * scenario:  list of votes for particular candidate is successfully viewed
     * input : mocked votedlist  object
     * list of  type votedList is created
     * expectation: all the votes for particular candidate is printed successfully
     */
    @Test
    void searchByNominatedCandidateId() {
        VotedList votedList = mock(VotedList.class);
        List<VotedList> list = new ArrayList<>();
        list.add(votedList);
        when(voteRepository.findByCandidate_CandidateID(123)).thenReturn(list);
        List<VotedList> result = service.searchByNominatedCandidateId(123);
        Assertions.assertEquals(list, result);


    }
}