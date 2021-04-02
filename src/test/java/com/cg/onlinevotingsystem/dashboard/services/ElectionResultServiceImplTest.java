package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.dashboard.dao.IElectionResultRepository;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.dashboard.exceptions.InvalidResultException;
import com.cg.onlinevotingsystem.dashboard.exceptions.ResultNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.INominatedCandidatesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class ElectionResultServiceImplTest {

    @Mock
    IElectionResultRepository electionResultRepository;

    @Mock
    INominatedCandidatesService candidatesService;

    @Spy
    @InjectMocks
    ElectionResultServiceImpl electionResultService;

    /**
     * scenario: result added successfully
     * input: result arg
     * expectation : verifying  electionResultRepository.save(resultArg) is called
     */
    @Test
    void addElectionResult_1() {
        ElectionResult resultArg = mock(ElectionResult.class);
        ElectionResult saved = mock(ElectionResult.class);
        when(electionResultRepository.save(resultArg)).thenReturn(saved);
        doNothing().when(electionResultService).validateResult(resultArg);
        ElectionResult result = electionResultService.addElectionResult(resultArg);
        Assertions.assertSame(saved, result);
        verify(electionResultRepository).save(resultArg);
    }

    @Test
    void testAddElectionResult_2() {
        ElectionResult resultArg = mock(ElectionResult.class);
        Executable executable = () -> electionResultService.addElectionResult(resultArg);
        Assertions.assertThrows(InvalidResultException.class, executable);
        verify(electionResultRepository, never()).save(resultArg);

    }


    @Test
    void viewElectionResultList() {
        List<ElectionResult> list = mock(List.class);
        when(electionResultRepository.findAll()).thenReturn(list);
        List<ElectionResult> result = electionResultService.viewElectionResultList();
        Assertions.assertSame(list, result);
        verify(electionResultRepository).findAll();
    }

    /**
     * scenario: result found for a candidate
     */
    @Test
    public void viewCandidatewiseResult_1(){
        int candidateId=6367;
        NominatedCandidates candidate=mock(NominatedCandidates.class);
        when(candidatesService.searchByCandidateID(candidateId)).thenReturn(candidate);
        ElectionResult fetchedResult=mock(ElectionResult.class);
        when(electionResultRepository.findElectionResultByCandidate(candidate)).thenReturn(fetchedResult);
       ElectionResult result=electionResultService.viewCandidatewiseResult(candidateId);
       Assertions.assertSame(fetchedResult,result);
       verify(electionResultRepository).findElectionResultByCandidate(candidate);
    }

    /**
     * scenario: result NOT found for a candidate
     *
     */
    @Test
    public void viewCandidatewiseResult_2(){
        int candidateId=6367;
        NominatedCandidates candidate=mock(NominatedCandidates.class);
        when(candidatesService.searchByCandidateID(candidateId)).thenReturn(candidate);

        ElectionResult fetchedResult=null;
        when(electionResultRepository.findElectionResultByCandidate(candidate)).thenReturn(fetchedResult);
        Executable executable=()->electionResultService.viewCandidatewiseResult(candidateId);
        Assertions.assertThrows(ResultNotFoundException.class,executable);
        verify(electionResultRepository).findElectionResultByCandidate(candidate);
    }

    @Test
    void viewCandidatewiseResult() {
        ElectionResult found = mock(ElectionResult.class);
        when(electionResultRepository.findById(1)).thenReturn(Optional.of(found));
        ElectionResult result = electionResultService.viewCandidatewiseResult(1);
        Assertions.assertEquals(found, result);
    }



}