/**
 * 
 */
package com.cucoex.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Company;
import com.cucoex.entity.User;
import com.cucoex.exception.UsernameOrIdNotFound;

/**
 * @author enrique
 *
 */
@Service
public class MonitorServiceImpl {
	
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

	
	@Autowired
	ComplianceService complianceService;
	
	/**
	 * 
	 */
	public MonitorServiceImpl() {
		
	}

	public void updateAllComplianceStatus()  {
		
		 complianceService.updateAllComplianceStatus();
		
		
	}
	
}
