package com.cg.onlinevotingsystem.cooperativesocietyms.controller;


import com.cg.onlinevotingsystem.cooperativesocietyms.dto.CooperativeSocietyDetails;
import com.cg.onlinevotingsystem.cooperativesocietyms.dto.CreateCooperativeSocietyRequest;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import com.cg.onlinevotingsystem.cooperativesocietyms.util.CooperativeSocietyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cooperativesociety")
@RestController
public class CooperativeSocietyController {
    @Autowired
    private ICooperativeSocietyService service;
    @Autowired
    private CooperativeSocietyUtil util;

    @PostMapping("/add")
    public CooperativeSocietyDetails addNewSociety(@RequestBody CreateCooperativeSocietyRequest request)
    {
        return util.details(service.addSocietyDetails(request.getSocietyName(), request.getHeadOfSociety(), request.getVillage(), request.getMandal(), request.getDistrict(), request.getPincode()));
    }

    @GetMapping("/byid/{id}")
    public CooperativeSocietyDetails findCooperativeSociety(@PathVariable("id") int id)
    {
        CooperativeSociety cs = service.viewSocietyById(id);
        CooperativeSocietyDetails finddetails = util.details(cs);
        return finddetails;
    }

    @DeleteMapping("byid/{id}")
    public CooperativeSocietyDetails deleteCooperativeSociety(@PathVariable("id") int id)
    {
        CooperativeSociety cs = service.deleteSociety(id);
        CooperativeSocietyDetails deletesociety = util.details(cs);
        return deletesociety;
    }


}
