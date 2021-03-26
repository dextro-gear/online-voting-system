package com.cg.onlinevotingsystem.dashboard.services;

import com.cg.onlinevotingsystem.dashboard.dao.IElectionResultRepository;
import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class ElectionResultServiceImplTest {

    @Mock
    IElectionResultRepository electionResultRepository;

    @Spy
    @InjectMocks
    ElectionResultServiceImpl electionResultService;

    @Test
    void addElectionResult() {
        // Test whether it returns the correct type
        ElectionResult saved = Mockito.mock(ElectionResult.class);
        Mockito.when(electionResultRepository.save(Mockito.any(ElectionResult.class))).thenReturn(saved);
        ElectionResult result = electionResultService.addElectionResult(Mockito.mock(NominatedCandidates.class), "tanjavur", 100, 60, 60, "fail");
        Assertions.assertEquals(saved, result);

    }

    @Test
    void viewElectionResultList() {
    }

    @Test
    void viewCandidatewiseResult() {
        ElectionResult found = Mockito.mock(ElectionResult.class);
        Mockito.when(electionResultRepository.findById(1)).thenReturn(Optional.of(found));
        ElectionResult result = electionResultService.viewCandidatewiseResult(1);
        Assertions.assertEquals(found, result);
    }

    @Test

    void viewVotingPercentage() {
//        float mockPercentage = (float)60.0;
//        Mockito.when(electionResult.)
    }

    @Test
    void viewCandidateVotingPercentage() {
    }

    @Test
    void displayVotingStatistics() {
    }

    @Test
    void viewHighestVotingPercentCandidate() {
    }

    @Test
    void viewLowestVotingPercentCandidate() {
    }

    @Test
    void viewInvalidVotes() {
    }

    @Test
    void candidatewiseInvalidVotesList() {
    }

    @Test
    void displayPollingResult() {
    }
}