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


    @Test
    void testAddNewSociety() {
        String district = "Zamir";
        String headOfSociety = "Mahil";
        String societyName = "Awadh";
        String mandal = "Bhima";
        String village = "Pushkar";
        String pincode = "589996";

        CreateCooperativeSocietyRequest request = new CreateCooperativeSocietyRequest();
        request.setDistrict(district);
        request.setHeadOfSociety(headOfSociety);
        request.setSocietyName(societyName);
        request.setMandal(mandal);
        request.setVillage(village);
        request.setPincode(pincode);

        CooperativeSociety society = Mockito.mock(CooperativeSociety.class);

        Mockito.when(service.addSocietyDetails(societyName,headOfSociety,village,mandal,district,pincode)).thenReturn(society);

        CooperativeSociety society1 = controller.addNewSociety(request);
        assertSame(society1,society);
        Mockito.verify(service).addSocietyDetails(societyName,headOfSociety,village,mandal,district,pincode);

    }

    @Test
    void findCooperativeSociety() {
        int id= 5;
        CooperativeSociety s1 =Mockito.mock(CooperativeSociety.class);
        Mockito.when(service.viewSocietyById(id)).thenReturn(s1);
        CooperativeSociety society  =controller.findCooperativeSociety(id);
        assertSame(s1,society);
        Mockito.verify(service).viewSocietyById(id);
    }

    @Test
    void testDeleteCooperativeSociety() {
        int id = 6;
        CooperativeSociety s2 = Mockito.mock(CooperativeSociety.class);
        Mockito.when(service.deleteSociety(id)).thenReturn(s2);
        CooperativeSociety society = controller.deleteCooperativeSociety(id);
        Mockito.verify(service).deleteSociety(id);
    }

}