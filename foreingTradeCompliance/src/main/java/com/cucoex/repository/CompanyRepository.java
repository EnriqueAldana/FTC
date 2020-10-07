/**
 * 
 */
package com.cucoex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cucoex.entity.Company;


/**
 * @author enrique
 *
 */
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	
	public Optional<Company> findByCompanyName(String companyname);
	public Optional<Company> findByCompanyEmail(String companyemail);
	public Optional<Company> findById(String id);
	//public Optional<ImpExpType> getAllImExpType();

}
