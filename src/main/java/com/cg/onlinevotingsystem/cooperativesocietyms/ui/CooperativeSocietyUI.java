package com.cg.onlinevotingsystem.cooperativesocietyms.ui;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;

import java.util.List;

@Component
public class CooperativeSocietyUI {
	@Autowired
	ICooperativeSocietyService service;
	
	public void display() {
			}
	


}
