package com.cg.onlinevotingsystem.cooperativesocietyms.controller;


import com.cg.onlinevotingsystem.cooperativesocietyms.dto.CreateCooperativeSocietyRequest;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/societies")
@RestController
public class CooperativeSocietyController {

    @Autowired
    private ICooperativeSocietyService societyService;

    @PostMapping("/add")
    public CooperativeSociety addNewSociety(@RequestBody CreateCooperativeSocietyRequest request) {
        CooperativeSociety society=new CooperativeSociety();
        society.setDistrict(request.getDistrict());
        society.setHeadOfSociety(request.getHeadOfSociety());
        society.setMandal(request.getMandal());
        society.setPincode(request.getPincode());
        society.setVillage(request.getVillage());
        society.setSocietyName(request.getSocietyName());
        return societyService.addSocietyDetails(society);
    }

    @GetMapping("/byid/{id}")
    public CooperativeSociety findCooperativeSociety(@PathVariable("id") int id) {
        return societyService.viewSocietyById(id);
    }

    @DeleteMapping("/delete/byid/{id}")
    public CooperativeSociety deleteCooperativeSociety(@PathVariable("id") int id) {
        return societyService.deleteSociety(id);
    }


}
