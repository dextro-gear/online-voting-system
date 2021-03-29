package com.cg.onlinevotingsystem.voterms.services;

import com.cg.onlinevotingsystem.voterms.dao.VoterRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.exceptions.VoterNotFoundException;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.lang.reflect.Executable;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class RegisteredSocietyVotersServiceImplTest {
    @Mock
    VoterRepository voterRepository;

    @Spy
    @InjectMocks
    RegisteredSocietyVotersServiceImpl service;

    @Test
    void voterRegistration() {
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        RegisteredSocietyVoters voterSaved = Mockito.mock(RegisteredSocietyVoters.class);

    }

    @Test
    void updateRegisteredVoterDetails() {
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        RegisteredSocietyVoters voterSaved = Mockito.mock(RegisteredSocietyVoters.class);
        when(voterRepository.save(voter)).thenReturn(voterSaved);
            RegisteredSocietyVoters result = service.updateRegisteredVoterDetails(voter);
            Assertions.assertNotNull(result);
            Assertions.assertEquals(voterSaved,result);
    }

    @Test
    void deleteRegisteredVoter() {

    }

    @Test
    void viewRegisteredVoterList() {

    }

    @Test
    void searchByVoterID() {
    }

    @Test
    void loginValidate() {
    }
}