/**
 * 
 */
package com.cucoex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Instruction;

/**
 * @author enrique
 *
 */
@Repository
public interface CausalRepository extends CrudRepository<Causal, Long> {

	
	public Optional<Causal> findById(String id);
	public Optional<Causal> findByCausalClasification(Long clasification);
	public Optional<Causal> findByCausalFraction(String fraccion);
	public Optional<Causal> findByCausalOsCe(String OsCe);
	public Optional<Causal> findByCausalExclusive(String exclusiva);
	public Iterable<Instruction> findInstructionListById(Long id);
	
	
}
