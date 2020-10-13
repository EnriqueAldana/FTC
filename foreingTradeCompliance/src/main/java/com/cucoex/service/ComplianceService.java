/**
 * 
 */
package com.cucoex.service;



import java.util.Collection;
import java.util.List;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Status;
import com.cucoex.exception.ComplianceException;

/**
 * @author enrique
 *
 */
public interface ComplianceService {
	
	
	public Compliance createCompliance(Compliance compliance) throws ComplianceException;

	public Compliance getComplianceById(Long id) throws ComplianceException;
	
	                            // getAllComplianceByCompanyIdAndImpExtTypeIdAndCausalId(Company company ImpExpType impExpType,Causal  causal)

	
	public Iterable<Compliance> getAllComplianceByCompanyAndImpExtTypeAndCausal(Company company,ImpExpType impExpType, Causal causal ) throws ComplianceException;
	
	public Iterable<Compliance> getAllCompliance() throws ComplianceException;

	
	public Iterable<Compliance> getAllComplianceByCompanyAndStatus(Company company, Status status ) throws ComplianceException;
	
	
	public Iterable<Compliance> getComplianceByCompanyAndImpExtType(Company company ,ImpExpType impExpType) throws ComplianceException;
	
	
	
	public Iterable<Compliance> getComplianceByCompany(Company company) throws ComplianceException;
	
	
	
	public Compliance updateCompliance(Compliance compliance) throws ComplianceException;
	
	public void deleteCompliance(Long id) throws ComplianceException;
	
	public Iterable<Compliance> createAllComplianceByCompanyId(Long id) throws ComplianceException;
	
	public Collection<Long> removeAllUseLessComplianceByCompanyId(Long id) throws ComplianceException;

	

	void updateAllComplianceStatus();


	void updateComplianceStatusByCompliance(Compliance compliance);

}
