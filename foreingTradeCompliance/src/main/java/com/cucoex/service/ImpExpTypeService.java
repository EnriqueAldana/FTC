/**
 * 
 */
package com.cucoex.service;

import java.util.Optional;

import com.cucoex.entity.Causal;
import com.cucoex.entity.ImpExpType;
import com.cucoex.exception.ImpExpTypeException;

/**
 * @author enrique
 *
 */
public interface ImpExpTypeService {
	
	public Iterable<ImpExpType> getAllImpExpType();
	
	public Iterable<Causal> getAllCausalsByImpExpTypeId(Long id) throws ImpExpTypeException;
	
	public Optional<ImpExpType> getImpExpTypeById(Long id) throws ImpExpTypeException;
	
}
