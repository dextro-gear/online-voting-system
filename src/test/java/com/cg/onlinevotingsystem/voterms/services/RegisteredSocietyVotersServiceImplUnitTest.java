package com.cg.onlinevotingsystem.voterms.services;

import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.exceptions.InvalidVoterException;
import com.cg.onlinevotingsystem.voterms.exceptions.VoterNotFoundException;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * contains for RegisteredSocietyVotersServiceImpl
 */
@ExtendWith(MockitoExtension.class)
public class RegisteredSocietyVotersServiceImplUnitTest {
    @Mock
    VoterRepository voterRepository;

    @Spy
    @InjectMocks
    RegisteredSocietyVotersServiceImpl service;

    /**
     * scenario: voter saved successfully
     * input: mocked voter object
     * expectation: voterRepository.save(voter) is called
     */
    @Test
    void testVoterRegistration_1() {
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        RegisteredSocietyVoters voterSaved = Mockito.mock(RegisteredSocietyVoters.class);
        doNothing().when(service).validateVoter(voter);
        when(voterRepository.save(voter)).thenReturn(voterSaved);
        String cardId="75667";
        doReturn(cardId).when(service).generateId();
        RegisteredSocietyVoters result = service.voterRegistration(voter);
        Assertions.assertSame(voterSaved, result);
        verify(voter).setVoterIdCardNo(cardId);
        verify(voterRepository).save(voter);
    }

    /**
     * scenario: voter not saved successfully
     * input: mocked voter object
     * expectation: InvalidVoterException is thrown , voterRepository.save(voter) is never called
     */
    @Test
    void testVoterRegistration_2() {
        RegisteredSocietyVoters voter = mock(RegisteredSocietyVoters.class);
        doThrow(InvalidVoterException.class).when(service).validateVoter(voter);
        Executable executable=()-> service.voterRegistration(voter);
        Assertions.assertThrows(InvalidVoterException.class,executable);
        verify(voterRepository,never()).save(voter);

    }

    /**
     * scenario: voter is updated successfully
     * input: mocked voter object
     * expectation: voterRepository.save(voter) is called
     */
    @Test
    void testUpdateRegisteredVoterDetails_1() {
        int id=7667;
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        when(voter.getId()).thenReturn(id);
        when(voterRepository.save(voter)).thenReturn(voter);
        when(voterRepository.existsById(id)).thenReturn(true);
        doNothing().when(service).validateVoter(voter);
        RegisteredSocietyVoters result = service.updateRegisteredVoterDetails(voter);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(voter, result);
        verify(voterRepository).save(voter);
    }


    /**
     * scenario: voter not saved successfully
     * input: mocked voter object
     * expectation: InvalidVoterException is thrown , voterRepository.save(voter) is never called
     */
    @Test
    void testUpdateRegisteredVoterDetails_2() {
        RegisteredSocietyVoters voter = mock(RegisteredSocietyVoters.class);
        doThrow(InvalidVoterException.class).when(service).validateVoter(voter);
        Executable executable=()-> service.updateRegisteredVoterDetails(voter);
        Assertions.assertThrows(InvalidVoterException.class,executable);
        verify(voterRepository,never()).save(voter);

    }

    /**
     * scenario: voter deleted successfully
     * input : 123 id
     * expectation:verifying voterRepository.deleteById(123) is called
     */
    @Test
    void testDeleteRegisteredVoter_1() {
        int id=123;
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        doReturn(voter).when(service).searchByVoterID(id);
        RegisteredSocietyVoters result = service.deleteRegisteredVoter(id);
        Assertions.assertEquals(voter, result);
        verify(voterRepository).deleteById(id);
    }

    /**
     * scenario: voter does not exist for id
     * input : 123 id
     * expectation: verifying  VoterNotFoundException is thrown
     */
    @Test
    void testDeleteRegisteredVoter_2() {
        int id=123;
        doThrow(VoterNotFoundException.class).when(service).searchByVoterID(id);
        Executable executable=()->service.deleteRegisteredVoter(id);
        Assertions.assertThrows(VoterNotFoundException.class ,executable);
        verify(voterRepository,never()).deleteById(id);
    }

    /**
     * scenario: voter list successfully viewed
     * input : mocked voter object
     * expectation: voterRepository.save(voter) is called
     */
    @Test
    void testViewRegisteredVoterList_1() {
        List list=mock(List.class);
        Mockito.when(voterRepository.findAll()).thenReturn(list);
        List<RegisteredSocietyVoters> result = service.viewRegisteredVoterList();
        Assertions.assertEquals(list, result);
        verify(voterRepository).findAll();
    }

    /**
     * scenario : voter fetched successfully from the store
     * input : id 123
     * expectation : verifying voter is fetched for id 123
     */
    @Test
    void testSearchByVoterID_1() {
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        Optional optional=Optional.of(voter);
        Mockito.when(voterRepository.findById(123)).thenReturn(optional);
        RegisteredSocietyVoters result = service.searchByVoterID(123);
        Assertions.assertEquals(result, voter);
        verify(voterRepository).findById(123);
    }

    /**
     * scenario : voter does not exist in store
     * input : id 123
     * expectation: verifying VoterNotFoundException is thrown
     */
    @Test
    public void testSearchByVoterId_2(){
        Optional optional=Optional.empty();
        Mockito.when(voterRepository.findById(123)).thenReturn(optional);
        Executable executable=()->service.searchByVoterID(123);
        Assertions.assertThrows(VoterNotFoundException.class,executable);
    }

}