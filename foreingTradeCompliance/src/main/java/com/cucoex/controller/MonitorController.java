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
import com.cucoex.service.MonitorServiceImpl;
import com.cucoex.util.Utileria;

@Controller
public class MonitorController {
	
	@Autowired
	MonitorServiceImpl monitorService;
	

	
	public MonitorController() {

	}
	
	// Ejecuta el monitor
			@GetMapping({"/runMonitor"})
			public String getRunMonitor() {
				System.out.println("Ejecución manual del monitor");
				/*
				 * El monitor es una tarea que tiene como objetivo valorar el estado de la causal
				 * en funcion de las fechas de vigencia, configuracion de la empresa y fecha de proxima verificación
				 * 
				 * Las reglas son:
				 * 
				 * Cada causal asignada a una empresa debera ser evaluada para determinar su estatus como sigue:
				 * Estatus de CUMPLIDA.
				 * 1.- Cuando el usuario mediante la pantalla de edicion determina que esta cumplida.
				 * 2.- Cuado la fecha actual es anterior a la fecha de vigencia y anterior a la fecha de proxima verificacion.
				 * 
				 * Estatus de  POR INCUMPLIR
				 * 1.- Cuando la fecha es mayor a la fecha de proxima verificacion y menor a la de vigencia.
				 * 
				 * Estatus de INCUMPLIDA
				 * 1.- Cuando al fecha es igual o mayor a la fecha de vigencia.
				 * 1
				 */
				monitorService.updateComplianceStatus();
				return "runManualMonitor";
			}

}
