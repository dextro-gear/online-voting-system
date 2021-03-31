package com.cg.onlinevotingsystem.cooperativesocietyms.controller;


import com.cg.onlinevotingsystem.cooperativesocietyms.dto.CreateCooperativeSocietyRequest;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cooperativesociety")
@RestController
public class CooperativeSocietyController {

    @Autowired
    private ICooperativeSocietyService societyService;

    @PostMapping("/add")
    public CooperativeSociety addNewSociety(@RequestBody CreateCooperativeSocietyRequest request) {
        return societyService.addSocietyDetails(request.getSocietyName(), request.getHeadOfSociety(), request.getVillage(), request.getMandal(), request.getDistrict(), request.getPincode());
    }

    @GetMapping("/byid/{id}")
    public CooperativeSociety findCooperativeSociety(@PathVariable("id") int id) {
        return societyService.viewSocietyById(id);
    }

    @DeleteMapping("byid/{id}")
    public CooperativeSociety deleteCooperativeSociety(@PathVariable("id") int id) {
        return societyService.deleteSociety(id);
    }


}
