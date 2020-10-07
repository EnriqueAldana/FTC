/**
 * 
 */
package com.cucoex.service;


import java.util.List;
import java.util.Set;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.Instruction;
import com.cucoex.exception.CausalException;


/**
 * @author enrique
 *
 */
public interface CausalService {
	
	public Iterable<Causal> getAllCausals();
	
	public Iterable<Instruction> getAllInstructionsByCausalId(Long id) throws CausalException;
	
	public Causal createCausal(Causal causal) throws CausalException;

	public Causal getCausalById(Long id) throws CausalException;
	
	public Causal updateCausal(Causal causal) throws CausalException;
	
	public void deleteCausal(Long id) throws CausalException;
	
	public List<Causal> getAllCausalByCompanyId(Long id) throws CausalException;
	
	

}
