/**
 * 
 */
package com.cucoex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Instruction;

/**
 * @author enrique
 *
 */
public interface ImpExpTypeRepository extends CrudRepository<ImpExpType, Long> {
	
	
	public Optional<ImpExpType> findById(String impExtType);
	public Optional<ImpExpType> findByImpExpTypeName(String impExtTypeName);
	

}
