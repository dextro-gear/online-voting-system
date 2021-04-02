package com.cg.onlinevotingsystem.nominatedcandidatems.services;

import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.InvalidCandidateException;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NominatedCandidateServiceImplTest {

    @Mock
    INominatedCandidateRepository candidateRepository;

    @Mock
    RegisteredSocietyVotersServiceImpl voterService;

    @Spy
    @InjectMocks
    NominatedCandidateServiceImpl candidatesService;

    /**
     * Scenario: NominatedCandidates object is successfully saved
     * Input: Mock Object of type NominatedCandidates; Stub methods are provided for repository.save() and validation
     * Expectations: repository.save method is called; the saved instance is returned;
     */
    @Test
    void addNominatedCandidate_1() {

        NominatedCandidates candidate = mock(NominatedCandidates.class);
        NominatedCandidates savedCandidate = mock(NominatedCandidates.class);

        // Stubbing the save method
        when(candidateRepository.save(candidate)).thenReturn(savedCandidate);

        // Stubbing the validation
        doNothing().when(candidatesService).validateCandidate(any(NominatedCandidates.class));

        // Verify the output is not null, is equal to the saved instance and verify the save() method is called
        NominatedCandidates result = candidatesService.addNominatedCandidate(candidate);
        assertEquals(savedCandidate, result);
        assertNotNull(result);
        verify(candidateRepository).save(candidate);

    }



    /**
     * Scenario: Validation fails while saving the object
     * Input: Mock Object of type NominatedCandidates; Stub methods are provided for repository.save()
     * Expectations: Verify the correct exception is thrown - InvalidCandidateException
     */
    @Test
    void addNominatedCandidate_2() {

        NominatedCandidates candidate = mock(NominatedCandidates.class);

        // Stubbing the validation
        doThrow(InvalidCandidateException.class).when(candidatesService).validateCandidate(any(NominatedCandidates.class));

        // Verify that InvalidCandidateException is thrown
        Executable executable = ()-> candidatesService.addNominatedCandidate(candidate);
        assertThrows(InvalidCandidateException.class, executable);

    }



    /**
     * Scenario: NominatedCandidates object is successfully updated
     * Input: Mock Object of type NominatedCandidates; Stub methods are provided for repository.save() and validation
     * Expectations: repository.save method is called; the saved instance is returned;
     */
    @Test
    void updateNominatedCandidateDetails_1() {
        int candidateID = 666;
        String nominationFormNo = "1231231231";
        RegisteredSocietyVoters voter = mock(RegisteredSocietyVoters.class);
        NominatedCandidates candidate = mock(NominatedCandidates.class);

        // Stubbing
        when(candidateRepository.findById(candidateID)).thenReturn(Optional.of(candidate));
        doReturn(voter).when(voterService).updateRegisteredVoterDetails(voter);
        doNothing().when(candidate).setNominationFormNo(nominationFormNo);
        doReturn(candidate).when(candidatesService).updateNominatedCandidateDetails(candidateID, nominationFormNo, voter);

        // Verify the save() method is  called
        NominatedCandidates result = candidatesService.updateNominatedCandidateDetails(candidateID, nominationFormNo, voter);
        verify(candidateRepository).save(candidate);
    }



    /**
     * Scenario: Candidate doesn't exist in the DB
     * Input: Mock Object of type NominatedCandidates; Stub methods are provided for repository.save() and validation
     * Expectations: The correct excpetion is thrown - CandidateNotFoundException
     */
    @Test
    void updateNominatedCandidateDetails_2() {
        int candidateID = 666;
        String nominationFormNo = "1231231231";
        RegisteredSocietyVoters voter = mock(RegisteredSocietyVoters.class);

        // Stubbing the update method to throw exception
        doThrow(CandidateNotFoundException.class).when(candidatesService).updateNominatedCandidateDetails(candidateID, nominationFormNo, voter);

        // Verify CandidateNotFoundException is thrown
        Executable executable = () -> candidatesService.updateNominatedCandidateDetails(candidateID, nominationFormNo, voter);
        assertThrows(CandidateNotFoundException.class, executable);

    }

    @Test
    void deleteNominatedCandidate() {
    }

    @Test
    void searchByCandidateID() {
    }

    @Test
    void viewNominatedCandidateList() {
    }


}