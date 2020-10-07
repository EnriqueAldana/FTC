/**
 * 
 */
package com.cucoex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Status;





/**
 * @author enrique
 *
 */
public interface ComplianceRepository extends CrudRepository<Compliance, Long> {
	
	public Optional<Compliance> findById(Long id);
	public Iterable<Compliance> findByCompany(Company company);
	public Iterable<Compliance> findByCompanyAndImpexptype(Company company ,  ImpExpType impExpType);
	
	public Iterable<Compliance> findByCompanyAndImpexptypeAndCausal(Company company, ImpExpType impExpType, Causal causal);
	
	public Iterable<Compliance> findByCompanyAndStatus(Company company,  Status status);
	
	public Iterable<Compliance> findByCompanyAndImpexptypeAndCausalAndStatus(Company company, ImpExpType impExpType, Causal causal, Status status);
	
	public  void deleteById(Long id);
	

}
