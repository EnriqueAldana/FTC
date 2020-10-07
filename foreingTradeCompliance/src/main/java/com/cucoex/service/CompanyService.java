package com.cucoex.service;





import java.sql.SQLIntegrityConstraintViolationException;

import com.cucoex.entity.Company;
import com.cucoex.entity.ImpExpType;
import com.cucoex.exception.CompanyException;

public interface CompanyService {
	
	public Iterable<Company> getAllCompanies();
	
	public Iterable<ImpExpType> getAllImpExpTypeByCompanyId(Long id) throws CompanyException;
	
	public Company createCompany(Company company) throws CompanyException;

	public Company getCompanyById(Long id) throws CompanyException;
	
	public Company updateCompany(Company user) throws CompanyException;
	
	public void deleteCompany(Long id) throws CompanyException, SQLIntegrityConstraintViolationException;
	

}
