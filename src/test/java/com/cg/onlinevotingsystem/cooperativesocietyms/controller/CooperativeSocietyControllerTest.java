package com.cg.onlinevotingsystem.cooperativesocietyms.controller;

import com.cg.onlinevotingsystem.cooperativesocietyms.dto.CreateCooperativeSocietyRequest;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CooperativeSocietyControllerTest {

    @Mock
    ICooperativeSocietyService service;

    @Spy
    @InjectMocks
    CooperativeSocietyController controller;


    /**
     * scenario: society exists in store
     * input: id
     * expectation: society fetched is the same mocked object which is stubbed
     */
    @Test
    void findCooperativeSociety() {
        int id= 5;
        CooperativeSociety s1 =Mockito.mock(CooperativeSociety.class);
        Mockito.when(service.viewSocietyById(id)).thenReturn(s1);
        CooperativeSociety society  =controller.findCooperativeSociety(id);
        assertSame(s1,society);
        Mockito.verify(service).viewSocietyById(id);
    }

    /**
     * scenario: society gets deleted in store
     * input: id
     * expectation: society deleted is the same mocked object which is stubbed
     */

    @Test
    void testDeleteCooperativeSociety() {
        int id = 6;
        CooperativeSociety s2 = Mockito.mock(CooperativeSociety.class);
        Mockito.when(service.deleteSociety(id)).thenReturn(s2);
        CooperativeSociety society = controller.deleteCooperativeSociety(id);
        Mockito.verify(service).deleteSociety(id);
    }

}