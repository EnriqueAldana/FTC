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
public interface InstructionRepository extends CrudRepository<Instruction, Long> {
	

}
