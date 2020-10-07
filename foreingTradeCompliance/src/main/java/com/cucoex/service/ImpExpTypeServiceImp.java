/**
 * 
 */
package com.cucoex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.ImpExpType;
import com.cucoex.exception.ImpExpTypeException;
import com.cucoex.repository.CompanyRepository;
import com.cucoex.repository.ImpExpTypeRepository;

/**
 * @author enrique
 *
 */
@Service
public class ImpExpTypeServiceImp implements ImpExpTypeService {
	
	@Autowired
	ImpExpTypeRepository repository;

	/**
	 * 
	 */
	public ImpExpTypeServiceImp() {
		
	}

	@Override
	public Iterable<ImpExpType> getAllImpExpType() {
		
		return repository.findAll();
	}

	@Override
	public Iterable<Causal> getAllCausalsByImpExpTypeId(Long id) throws ImpExpTypeException {
			Optional<ImpExpType> impExpTypeFound = Optional.ofNullable(new ImpExpType());
		
			impExpTypeFound = getImpExpTypeById(id);
		
		return impExpTypeFound.get().getCausalList();
		
	}
	
	@Override
	public Optional<ImpExpType> getImpExpTypeById(Long id) throws ImpExpTypeException {
		
		return repository.findById(id);
	}

}
