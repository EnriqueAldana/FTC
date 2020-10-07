package com.cucoex.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Status;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.ComplianceException;
import com.cucoex.repository.StatusRepository;
import com.cucoex.service.CompanyService;
import com.cucoex.service.ComplianceService;
import com.cucoex.util.Utileria;

@Controller
public class MonitorController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ComplianceService complianceService;
	
	@Autowired
	StatusRepository statusRepository;

	
	public MonitorController() {

	}
	
	// Ejecuta el monitor
			@GetMapping({"/runMonitor"})
			public String getRunMonitor(Model model) {
				System.out.println("Ejecución manual del monitor");
				// Actualizar un compliance para una jerarquia especifica - Company,ImpExtType, Causal
				Collection<Compliance> complianListAdded= new ArrayList<Compliance>();
				Collection<Long> complianListRemoved= new ArrayList<Long>();
				try {
					complianListAdded= (Collection<Compliance>) complianceService.createAllComplianceByCompanyId(2L);
					complianListRemoved = complianceService.removeAllUseLessComplianceByCompanyId(2L);
				} catch (ComplianceException e) {
					
					e.printStackTrace();
				}
				
				System.out.println("Registros insertados " + complianListAdded.size());
				System.out.println("Registros eliminado " + complianListRemoved.size());
				
				return "runMonitor/runMonitor";
			}

}
