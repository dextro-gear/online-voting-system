package com.cg.onlinevotingsystem.cooperativesocietyms.service;

import com.cg.onlinevotingsystem.cooperativesocietyms.dao.ICooperativeSocietyDaoRepository;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @Test
    void deleteSociety() {
    }

    @Test
    void viewSocietyList() {
        List<CooperativeSociety> list = new ArrayList<CooperativeSociety>();
        CooperativeSociety society1 = new CooperativeSociety("migan", "miesha", "sursuri", "gantantra", "kahar", "480608");
        CooperativeSociety society2 = new CooperativeSociety("Meraki", "mahira", "devgarh", "janana", "Kaman", "610401");
        list.add(society1);
        list.add(society2);
        when(repository.findAll()).thenReturn(list);

        List<CooperativeSociety>cooperativeSocietyList = service.viewSocietyList();
        assertEquals(2,cooperativeSocietyList.size());

    }

    @Test
    void viewSocietyById(){

            CooperativeSociety list = Mockito.mock(CooperativeSociety.class);
            when(repository.findById(1)).thenReturn(Optional.ofNullable(list));
            CooperativeSociety l1 = service.viewSocietyById(1);
            Assertions.assertEquals(l1,list);


    }
}