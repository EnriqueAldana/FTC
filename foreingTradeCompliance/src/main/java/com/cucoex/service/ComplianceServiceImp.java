/**
 * 
 */
package com.cucoex.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Status;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.ComplianceException;
import com.cucoex.repository.ComplianceRepository;
import com.cucoex.repository.StatusRepository;
import com.cucoex.util.StatusKey;
import com.cucoex.util.Utileria;


/**
 * @author enrique
 *
 */
@Service
public class ComplianceServiceImp implements ComplianceService {
	
	@Autowired
	ComplianceRepository complianceRepository;

	
	
	

	@Autowired
	CompanyService companyService;
	
	
	@Autowired
	StatusRepository statusRepository;


	
	/**
	 * 
	 */
	public ComplianceServiceImp() {
		
	}

	@Override
	public Compliance createCompliance(Compliance compliance) throws ComplianceException {
		
		compliance = complianceRepository.save(compliance);
		return compliance;
	}
	
	/*
	 * 
	 * Creamos los registros en la tabla de COmpliance en funcion de la estructura de la empresa
	 * Si ya estan solo se actualiza el campo de updated
	 * 
	 * 
	 */
	public Iterable<Compliance> createAllComplianceByCompanyId(Long id) throws ComplianceException{
		
		Calendar hoy = Calendar.getInstance();
		Calendar effectiveDateForCompliance = Calendar.getInstance();
		// LocalDate effectiveDateForCompliance = Utileria.LocalDateTodayDate().plusDays(30L);
		effectiveDateForCompliance = Utileria.sumarDias(effectiveDateForCompliance, 30);
		Calendar complianceEvaluationDate = Calendar.getInstance();
		//LocalDate complianceEvaluationDate = Utileria.LocalDateTodayDate().plusDays(30L);
		
		complianceEvaluationDate = Utileria.sumarDias(complianceEvaluationDate, 0);
		
		Calendar created = hoy;
		Calendar updated= hoy;
		Status status = new Status();
		status = statusRepository.findByStatusKey("INCUM");
		Compliance compliancefound = null;
		Collection<Compliance> complianList= new ArrayList<Compliance>();
		
		try {
				Company empresa = companyService.getCompanyById(id);
				

				for(ImpExpType  impExpType :  empresa.getImpExpTypeList()) {
					  //System.out.println("ImpExpType : " + impExpType.toString());
					
					for (Causal causal: impExpType.getCausalList()) {
								
						//System.out.println("Causal : " + causal.toString());
						
						// Determinar si es insercion o actualizacion
						 Iterable<Compliance> complianceUpdated = getAllComplianceByCompanyAndImpExtTypeAndCausal(empresa, impExpType, causal);
						
						// Buscar el registro en la lista
						 compliancefound = null;
						for(Compliance listaReg: complianceUpdated ) {
							compliancefound = null;   // Asumimos que el registro sera nuevo
							if(listaReg.getCompany().getId() == empresa.getId()){
								if(listaReg.getImpexptype().getId() == impExpType.getId()) {
									if(listaReg.getCausal().getId() == causal.getId()) {
										compliancefound = listaReg;
									}
								}
							}
							
						}	
							
						if (compliancefound == null) {   // SI el registro por insertar no esta en la lista
							
							try {
								
								Compliance compliance = new Compliance(empresa, impExpType, causal, effectiveDateForCompliance , complianceEvaluationDate, created, updated, status);
								complianList.add(createCompliance(compliance));
								
							}catch (org.springframework.dao.DataIntegrityViolationException exp) {
								System.out.println("El registro para la empresa  " + empresa.getId() + " con ImpExpType " + impExpType.getId() + " y causal  " + causal.getId() + " Ya existe");
								exp.printStackTrace();
							}
						} else {
							System.out.println("Actualizacion de registro en la tabla de cumplimiento");
							// Mandar actualizar por ComplianceFound
							System.out.println("Registro por actualizar" + compliancefound.toString());
							
							System.out.println("Registro actualizado" + updateCompliance(compliancefound));
							
						}
							
					}
					
				}  // fin iterador de ImpExtType
				
				
				
		

		} catch (CompanyException e) {
			e.printStackTrace();
			throw new ComplianceException("Ha habido un error en la obtencion de la empresa");
			
		} catch (ComplianceException e) {
			e.printStackTrace();
			throw new ComplianceException("Ha habido un error en la insercion de registros de cumplimiento");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ComplianceException("Ha habido un error en la insercion de registros de cumplimiento");
		}
		
		
		return complianList;
		
		
	}

	/*
	 * 
	 * Removemos los registros que esten en la tabla de Compliance que ya no esten definidos en la 
	 * estructura de la empresa
	 * 
	 * 
	 */
	public Collection<Long> removeAllUseLessComplianceByCompanyId(Long id) throws ComplianceException{
		
		Long compliancefound = 0L;
		Collection<Long> foundedRecords = new ArrayList<Long>();
		Collection<Long> deletedRecords = new ArrayList<Long>();
		try {
			Company empresa = companyService.getCompanyById(id);
			
			
			/*  SUSTRACCION DE LISTAS
			 * List<Integer> list1 = Arrays.asList(1, 2, 3); List<Integer> list2 =
			 * Arrays.asList(1, 2, 4, 5); List<Integer> diff = list1.stream() .filter(e ->
			 * !list2.contains(e)) .collect (Collectors.toList()); // (3)
			 */			
			
			
			// Traer todos los registros de cumplimiento de la empresa
			
			Iterable<Compliance> companyList = complianceRepository.findByCompany(empresa);
			
			
			for(ImpExpType  impExpType :  empresa.getImpExpTypeList()) {
				  System.out.println("ImpExpType : " + impExpType.toString());
				
				for (Causal causal: impExpType.getCausalList()) {
							
					System.out.println("Causal : " + causal.toString());
						
					// Buscar el registro en la lista
					compliancefound = 0L;
					for(Compliance companyListRecords: companyList ) {
						System.out.println("Cumplimiento de la lista completa para la empresa " + empresa.getId());
						System.out.println(companyListRecords.toString());
						System.out.println("Indices de la estructura " + empresa.getId() + " " +impExpType.getId() + " " + causal.getId());
						if(companyListRecords.getCompany().getId() == empresa.getId()){
							if(companyListRecords.getImpexptype().getId() == impExpType.getId()) {
								if(companyListRecords.getCausal().getId() == causal.getId()) {
									// SI el registro de la actual estructura de la empresa esta en la lista de registros se debe dejar y por lo tanto tomamos su id
									foundedRecords.add(companyListRecords.getId());
								}
							}
						}
						
						
					}  // fin companyListRecords
					
				}
				
			}  // fin iterador de ImpExtType
			
			// Eliminar los que no se encontraron
			for(Compliance companyListRecords: companyList ) {
				
				if ( !foundedRecords.contains(companyListRecords.getId())) {
					deleteCompliance(companyListRecords.getId());
					deletedRecords.add(companyListRecords.getId());
					// System.out.println("Registro de cumplimiento eliminado " + companyListRecords.getId());
				}
			}
		
			
	

	} catch (CompanyException e) {
		e.printStackTrace();
		throw new ComplianceException("Ha habido un error en la obtencion de la empresa");
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new ComplianceException("Ha habido un error en la eliminacion de registros de cumplimiento");
	}

		
		
		return deletedRecords;
		
	}
	@Override
	public Compliance getComplianceById(Long id) throws ComplianceException {
		
		return complianceRepository.findById(id).orElseThrow(() -> new ComplianceException("El Id del cumplimiento no existe."));
		 
	}

	 							
	@Override
	@Transactional(readOnly = true)  // Con esto obligamos a que lea siempre de la BD
	public Iterable<Compliance> getAllComplianceByCompanyAndImpExtTypeAndCausal(Company company ,ImpExpType impExpType,Causal  causal) throws ComplianceException {
		
		return complianceRepository.findByCompanyAndImpexptypeAndCausal(company, impExpType,causal);
	}

	@Override
	public Iterable<Compliance> getAllComplianceByCompanyAndStatus(Company company ,Status  status) throws ComplianceException {
		
		return complianceRepository.findByCompanyAndStatus(company,status);
	}
	
	@Override 					
	public Iterable<Compliance> getComplianceByCompanyAndImpExtType(Company company ,ImpExpType impExpType) throws ComplianceException {
		
		return complianceRepository.findByCompanyAndImpexptype(company, impExpType);
	}

	@Override
	public Iterable<Compliance> getComplianceByCompany(Company company) throws ComplianceException {
		
		return complianceRepository.findByCompany(company);
	}

	@Override
	public Compliance updateCompliance(Compliance compliance) throws ComplianceException {
		
		
		  Calendar hoy = Calendar.getInstance();
		  
		  
		  Optional <Compliance> complianceUpdated = complianceRepository.findById(compliance.getId()); 
		  if(complianceUpdated.isPresent() ) {
			  //System.out.println("Cumplimiento por actualizar " +
			  //complianceUpdated.toString());
			  mapCompliance(compliance,complianceUpdated.get());
			  complianceUpdated.get().setUpdated(hoy); // complianceUpdated = compliance =
			  compliance= complianceRepository.save(complianceUpdated.get());
			 // System.out.println("Cumplimiento actualizada " +
			  //complianceUpdated.toString());
		  
		  }else { throw new
		  ComplianceException("El cumplimiento no disponible para actualizar"); }
		 
		  
		  return compliance;

	}

	@Override
	public void deleteCompliance(Long id) throws ComplianceException {
					
						Compliance complianceFound = getComplianceById(id);
		
						if (complianceFound  != null) {
							// System.out.println("Borrando el cumplimiento " + id);
							complianceRepository.deleteById(id);
							
							
						}else {
							 throw new ComplianceException("Id de cumplimiento no disponible para eliminar"); 
						}

	}
	
	protected void mapCompliance(Compliance from,Compliance to) {
		to.setId(from.getId());
		if(null != from.getCausal()) {
			to.setCausal(from.getCausal());
		}
		if(null != from.getCompany()){
			to.setCompany(from.getCompany());
		}
		if (null != from.getImpexptype()) {
			to.setImpexptype(from.getImpexptype());
		}
		if (null != from.getComplianceEvaluationDate()) {
			to.setComplianceEvaluationDate(from.getComplianceEvaluationDate());
		}
		if ( null != from.getCreated()) {
			to.setCreated(from.getCreated());
		}
		if (null != from.getEffectiveDateForCompliance()) {
			to.setEffectiveDateForCompliance(from.getEffectiveDateForCompliance());
		}
		if ( null != from.getStatus()) {
			to.setStatus(from.getStatus());
		}
		if ( null != from.getUpdated()) {
			to.setUpdated(from.getUpdated());
		}
		
		
	}

	@Override
	public Iterable<Compliance> getAllCompliance() throws ComplianceException {
		
		Iterable<Compliance> complianceList = complianceRepository.findAll();
		
		return complianceList;
	}


	@Override
	public void updateAllComplianceStatus() {
		
		Iterable<Compliance> complianceList = null;
		Status statusCUMP = new Status();
		Status statusXINCUMP = new Status();
		Status statusINCUMP = new Status();
		try {
			statusCUMP = statusRepository.findByStatusKey(StatusKey.CUMP.toString());
			statusXINCUMP = statusRepository.findByStatusKey(StatusKey.XINCUM.toString());
			statusINCUMP = statusRepository.findByStatusKey(StatusKey.INCUM.toString());
			
			complianceList = this.getAllCompliance();
			for(Compliance compliance : complianceList) {
					Compliance complianceFounded = getComplianceById(compliance.getId());		
					updateComplianceStatusAccordingToday(compliance);
			}
			
		} catch (ComplianceException e) {
			e.printStackTrace();
		}

		
	}

	
	
	@Override
	public void updateComplianceStatusByCompliance(Compliance compliance) {
		
		
		try {
			
			updateComplianceStatusAccordingToday(compliance);

		} catch (ComplianceException e) {
			e.printStackTrace();
		}

		
	}
	
	private void updateComplianceStatusAccordingToday(Compliance complianceToUpdate) throws ComplianceException{
		
		Status statusCUMP = new Status();
		Status statusXINCUMP = new Status();
		Status statusINCUMP = new Status();
		statusCUMP = statusRepository.findByStatusKey(StatusKey.CUMP.toString());
		statusXINCUMP = statusRepository.findByStatusKey(StatusKey.XINCUM.toString());
		statusINCUMP = statusRepository.findByStatusKey(StatusKey.INCUM.toString());
		
		Calendar today = Utileria.getCalendarToday();
		
		//LocalDate today= Utileria.LocalDateTodayDate();
		
		Compliance compliance = getComplianceById(complianceToUpdate.getId());
		
		  int Today_VS_EffectiveDateForCompliance = Utileria.calendarcompareTo(today,
		  compliance.getEffectiveDateForCompliance()); int
		  Today_VS_ComplianceEvaluationDate=Utileria.calendarcompareTo(today,
		  compliance.getComplianceEvaluationDate());
		 
		//int Today_VS_EffectiveDateForCompliance = Utileria.localDateCompareto(today, compliance.getEffectiveDateForCompliance());
		//int Today_VS_ComplianceEvaluationDate=Utileria.localDateCompareto(today, compliance.getComplianceEvaluationDate());
		
	
		// El dia de hoy es el mismo que el de vigencia y la proxima evaluacion  por lo tanto estaRA VIGENTE
		if(Today_VS_EffectiveDateForCompliance == 0 && Today_VS_ComplianceEvaluationDate ==0) {
			if (!compliance.getStatus().getStatusKey().equals(StatusKey.CUMP.toString())) {
				compliance.setStatus(statusCUMP);
				updateCompliance(compliance);
				// Actualizar a CUMP
			}
			
		}
		
		if(Today_VS_EffectiveDateForCompliance < 0 && Today_VS_ComplianceEvaluationDate < 0) {
			if (!compliance.getStatus().getStatusKey().equals(StatusKey.CUMP.toString())) {
				compliance.setStatus(statusCUMP);
				updateCompliance(compliance);
				// Actualizar a CUMP
			}
		}

		if(Today_VS_EffectiveDateForCompliance < 0 && (Today_VS_ComplianceEvaluationDate ==0 || Today_VS_ComplianceEvaluationDate > 0)) {
			if (!compliance.getStatus().getStatusKey().equals(StatusKey.XINCUM.toString())) {
				compliance.setStatus(statusXINCUMP);
				updateCompliance(compliance);
				// Actualizar a XINCUM
			}
			
		}
				
		if (Today_VS_EffectiveDateForCompliance > 0 ) {
			if (!compliance.getStatus().getStatusKey().equals(StatusKey.INCUM.toString())) {
				compliance.setStatus(statusINCUMP);
				updateCompliance(compliance);
				// Actualizar a INCUM
			}
			
		}
		
		if (Today_VS_EffectiveDateForCompliance == 0 ) {
			if (!compliance.getStatus().getStatusKey().equals(StatusKey.INCUM.toString())) {
				compliance.setStatus(statusCUMP);
				updateCompliance(compliance);
				// Actualizar a CUM
			}
			
		}
		
	}

	


}
