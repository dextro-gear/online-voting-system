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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

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
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        RegisteredSocietyVoters voterSaved = Mockito.mock(RegisteredSocietyVoters.class);
        Mockito.when(voterRepository.findById(123)).thenReturn(Optional.of(Mockito.mock(RegisteredSocietyVoters.class)));
        RegisteredSocietyVoters result = service.deleteRegisteredVoter(123);
        Assertions.assertEquals(voter,result);
    }

    @Test
    void viewRegisteredVoterList() {
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        List<RegisteredSocietyVoters> list = new ArrayList<>();
        list.add(voter);
        Mockito.when(voterRepository.findAll()).thenReturn(list);
        List<RegisteredSocietyVoters> result = service.viewRegisteredVoterList();
        Assertions.assertEquals(list,result);

    }

    @Test
    void searchByVoterID() {
        RegisteredSocietyVoters voter = Mockito.mock(RegisteredSocietyVoters.class);
        Mockito.when(voterRepository.findById(123)).thenReturn(Optional.ofNullable(voter));
        RegisteredSocietyVoters result = service.searchByVoterID(123);
        Assertions.assertEquals(result,voter);
    }

    @Test
    void loginValidate() {
    }
}