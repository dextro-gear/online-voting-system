package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;

import com.cg.onlinevotingsystem.cooperativesocietyms.exceptions.SocietyNotFoundException;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CooperativeSocietyServiceImplTest {

    @Mock
    ICooperativeSocietyDaoRepository repository;

    @Spy
    @InjectMocks
    CooperativeSocietyServiceImpl service;

    @Test
    void testAddSocietyDetails() {

    }

    @Test
    void updateSocietyDetails() {
    }



    /**
     * scenario: society list in store
     * input: list
     * expectation: society list fetched is the same mocked object which is stubbed
     */
    @Test
    void deleteSociety() {
    }


    /**
     * scenario: society list in store
     * input: list
     * expectation: society list fetched is the same mocked object which is stubbed
     */

    @Test
    void TestViewSocietyList() {
        List list = mock(List.class);
        when(repository.findAll()).thenReturn(list);
        List<CooperativeSociety> result = service.viewSocietyList();
        assertSame(list, result);
        verify(repository).findAll();

    }

    /**
     * scenario: society exists in store
     * input: id 1
     * expectation: society fetched is the same mocked object which is stubbed
     */
    @Test
    void TestViewSocietyById_1() {
        CooperativeSociety society = Mockito.mock(CooperativeSociety.class);
        Optional optional=Optional.of(society);
        when(repository.findById(1)).thenReturn(optional);
        CooperativeSociety l1 = service.viewSocietyById(1);
        Assertions.assertEquals(l1, society);
        verify(repository).findById(1);
    }

}