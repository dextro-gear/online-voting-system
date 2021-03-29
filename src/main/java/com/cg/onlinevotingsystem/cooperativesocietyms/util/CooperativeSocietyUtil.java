package com.cg.onlinevotingsystem.cooperativesocietyms.util;


import com.cg.onlinevotingsystem.cooperativesocietyms.dto.CooperativeSocietyDetails;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import org.springframework.stereotype.Component;

@Component
public class CooperativeSocietyUtil {
    public CooperativeSocietyDetails details(CooperativeSociety cooperativeSociety){
        CooperativeSocietyDetails cs = new CooperativeSocietyDetails();
        cs.setSocietyId(cooperativeSociety.getSocietyId());
        cs.setHeadOfSociety(cooperativeSociety.getHeadOfSociety());
        cs.setSocietyName(cooperativeSociety.getSocietyName());
        cs.setDistrict(cooperativeSociety.getDistrict());
        cs.setMandal(cooperativeSociety.getMandal());
        cs.setVillage(cooperativeSociety.getVillage());
        cs.setPincode(cooperativeSociety.getPincode());
        return cs;
    }
}
