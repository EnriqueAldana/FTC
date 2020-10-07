/**
 * 
 */
package com.cucoex.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Company;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.User;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.CompanyRepository;

/**
 * @author enrique
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	CompanyRepository repository;

	/**
	 * 
	 */
	public CompanyServiceImpl() {
		
	}


	@Override
	public Iterable<Company> getAllCompanies() {
		
		return repository.findAll();
	}

	@Override
	public Iterable<ImpExpType> getAllImpExpTypeByCompanyId(Long id) throws CompanyException{
		
		Company companyFound = new Company();
		
		companyFound= getCompanyById(id);
		
		return companyFound.getImpExpTypeList();
	}


	@Override
	public Company createCompany(Company company) throws CompanyException {
		try {
			company = repository.save(company);
		}catch( org.hibernate.exception.ConstraintViolationException ex) {
			throw new CompanyException("El RFC ya existe " );
		}catch (org.springframework.dao.DataIntegrityViolationException ei) {
			System.out.println("El RFC ya existe. " + ei.getMostSpecificCause().getMessage());
			throw new CompanyException("El RFC ya existe. "  );
		}
		
		return company;
	}

	@Override
	public Company getCompanyById(Long id) throws CompanyException {
		
		return repository.findById(id).orElseThrow(() -> new CompanyException("El Id de la empresa no existe."));

	}

	@Override
	public Company updateCompany(Company company) throws CompanyException {
		
			Calendar today = Calendar.getInstance(); 
		
		  Company companyUpdated = getCompanyById(company.getId());
		  
		  
		 if(companyUpdated != null )
		  { 
			 System.out.println("Empresa por actualizar "  + companyUpdated.toString());
			 mapCompany(company,companyUpdated);
			 companyUpdated.setUpdated(today);
		     
             companyUpdated = repository.save(companyUpdated);
		     
		     System.out.println("Empresa actualizada " + companyUpdated.toString());
		  
		  }else { 
			  throw new CompanyException("La empresa " + company.getId() + "  no está disponible para actualizar"); }
		  
		  return companyUpdated;
		  
	}

	@Override
	public void deleteCompany(Long id) throws CompanyException {
		Optional<Company> companyFound = repository.findById(id);
		if (companyFound.isPresent()) {
			
			try {
				repository.deleteById(id);
			}catch( org.hibernate.exception.ConstraintViolationException ex) {
				throw new CompanyException("La empresa no puede ser eliminada mientras tenga usuarios asignados " );
			}catch (org.springframework.dao.DataIntegrityViolationException ei) {
				System.out.println("La empresa no puede ser eliminada " + ei.getMostSpecificCause().getMessage());
				throw new CompanyException("La empresa no puede ser eliminada mientras tenga usuarios asignados" );
			}
			
			
		}else {
			throw new CompanyException("La empresa " + id + "  no está disponible para eliminar");
		}
		
	}



	@Override
	public String toString() {
		return "CompanyServiceImpl [getAllComanies()=" +  "]";
	}


	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapCompany(Company from,Company to) {
		
		
		
		to.setAlertMessage(from.getAlertMessage());
		to.setAreAlertsEnabled(from.getAreAlertsEnabled());
		to.setAreAlertsEnabledToAdministrators(from.getAreAlertsEnabledToAdministrators());
		to.setAreAlertsEnabledToSupervisors(from.getAreAlertsEnabledToSupervisors());
		to.setAreAlertsEnabledToUsers(from.getAreAlertsEnabledToUsers());
		to.setCompanyAddress(from.getCompanyAddress());
		to.setCompanyEmail(from.getCompanyEmail());
		to.setCompanyId(from.getCompanyId());
		to.setCompanyName(from.getCompanyName());
		to.setCompanyPhone(from.getCompanyPhone());
		to.setCompanyWeb(from.getCompanyWeb());
		to.setDaysToClimbAlertsToAdministrator(from.getDaysToClimbAlertsToAdministrator());
		to.setDaysToClimbAlertsToSupervisor(from.getDaysToClimbAlertsToSupervisor());
		to.setDaysToDefault(from.getDaysToDefault());
		to.setFrequencyToRunMonitor(from.getFrequencyToRunMonitor());
		to.setImpExpTypeList(from.getImpExpTypeList());
		to.setIsEnabled(from.getIsEnabled());
	

	}


	


	
}
