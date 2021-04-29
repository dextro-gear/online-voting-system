package com.cg.onlinevotingsystem.cooperativesocietyms.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;


@Component
public class CooperativeSocietyUI {
	@Autowired
	ICooperativeSocietyService service;

	private static final Logger LOG = LoggerFactory.getLogger(CooperativeSocietyUI.class);

	public void display() {
		CooperativeSociety s1 = new CooperativeSociety();
		s1.setSocietyName("Meraki");
		s1.setHeadOfSociety("Dev");
		s1.setVillage("Verumbakam");
		s1.setMandal("Mesur");
		s1.setDistrict("Teni");
		s1.setPincode("111111");
		s1 = service.addSocietyDetails(s1);


		CooperativeSociety s2 = new CooperativeSociety();
		s2.setSocietyName("sakki");
		s2.setHeadOfSociety("Deviya");
		s2.setVillage("minambakam");
		s2.setMandal("Meshur");
		s2.setDistrict("Theni");
		s2.setPincode("222222");
		service.addSocietyDetails(s2);

		CooperativeSociety s3 = new CooperativeSociety();
		s3.setSocietyName("Sandar");
		s3.setHeadOfSociety("Shiv");
		s3.setVillage("karrembakam");
		s3.setMandal("Miniasi");
		s3.setDistrict("Erode");
		s3.setPincode("333333");
		service.addSocietyDetails(s3);

		CooperativeSociety s4 = new CooperativeSociety();
		s4.setSocietyName("Menaar");
		s4.setHeadOfSociety("Anika");
		s4.setVillage("chanderi");
		s4.setMandal("Kaamna");
		s4.setDistrict("Jhansi");
		s4.setPincode("444444");
		service.addSocietyDetails(s4);

		CooperativeSociety s5 = new CooperativeSociety();
		s5.setSocietyName("Mugil");
		s5.setHeadOfSociety("Devraj");
		s5.setVillage("basheera");
		s5.setMandal("Aakash");
		s5.setDistrict("Mirzapur");
		s5.setPincode("555555");
		service.addSocietyDetails(s5);

		CooperativeSociety s6 = new CooperativeSociety();
		s6.setSocietyName("Sikant");
		s6.setHeadOfSociety("Vijay");
		s6.setVillage("chiniyam");
		s6.setMandal("Megham");
		s6.setDistrict("Amravati");
		s6.setPincode("666666");
		service.addSocietyDetails(s6);

		CooperativeSociety s7 = new CooperativeSociety();
		s7.setSocietyName("Vinayam");
		s7.setHeadOfSociety("Indra");
		s7.setVillage("devgarh");
		s7.setMandal("Paripakta");
		s7.setDistrict("Chiyaan");
		s7.setPincode("777777");
		service.addSocietyDetails(s7);

		CooperativeSociety s8 = new CooperativeSociety();
		s8.setSocietyName("Maghil");
		s8.setHeadOfSociety("Mandana");
		s8.setVillage("kovur");
		s8.setMandal("Damina");
		s8.setDistrict("Kohlapur");
		s8.setPincode("888888");
		service.addSocietyDetails(s8);

		CooperativeSociety s9 = new CooperativeSociety();
		s9.setSocietyName("Shakti");
		s9.setHeadOfSociety("Somnath");
		s9.setVillage("kosuvampalayam");
		s9.setMandal("Soch");
		s9.setDistrict("Mulugu");
		s9.setPincode("999999");
		service.addSocietyDetails(s9);

		CooperativeSociety s10 = new CooperativeSociety();
		s10.setSocietyName("Muham");
		s10.setHeadOfSociety("Anish");
		s10.setVillage("chandrapur");
		s10.setMandal("Dharti");
		s10.setDistrict("Chinima");
		s10.setPincode("101010");
		service.addSocietyDetails(s10);

		LOG.info("SOCIETIES CREATION");
		LOG.debug(s1.toString());
		LOG.debug(s2.toString());
		LOG.debug(s3.toString());
		LOG.debug(s4.toString());
		LOG.debug(s5.toString());
		LOG.debug(s6.toString());
		LOG.debug(s7.toString());
		LOG.debug(s8.toString());
		LOG.debug(s9.toString());
		LOG.debug(s10.toString());

	}

}
