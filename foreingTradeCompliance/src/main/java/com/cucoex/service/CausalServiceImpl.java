/**
 * 
 */
package com.cucoex.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Instruction;
import com.cucoex.exception.CausalException;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.ComplianceException;
import com.cucoex.repository.CausalRepository;
import com.cucoex.repository.ImpExpTypeRepository;


/**
 * @author enrique
 *
 */
@Service
public class CausalServiceImpl implements CausalService {
	
	@Autowired
	CausalRepository repository;
	
	@Autowired
	ImpExpTypeRepository impExpTypeRepository;
	
	@Autowired
	CompanyService companyService;
	
	/**
	 * 
	 */
	public CausalServiceImpl() {
		
	}

	public List<Causal> getAllCausalByCompanyId(Long id) throws CausalException{
		Company empresa = new Company();
		List<Causal> causalList =  new ArrayList<Causal>();
		
		try {
			 empresa= companyService.getCompanyById(id);
		} catch (CompanyException e) {
	
			 throw new CausalException("La empresa " + id + "  no está disponible para proporcionar la lista de causales");
			
		}
		
		for(ImpExpType  impExpType :  empresa.getImpExpTypeList()) {
			
			
			for (Causal causal: impExpType.getCausalList()) {
				
				causalList.add(causal);
				
			}
		}
		
		
		 
		List<Causal> causalSorted = causalList.stream().collect(Collectors.toList());
		
		Collections.sort(causalSorted, (o1, o2) -> o1.getId().compareTo(o2.getId()));
			
		return causalSorted;
		
	}
	
	public Iterable<Causal> getAllCausalByImpExpTypeId (Long impExpTypeId) throws CausalException{
		Optional<ImpExpType> impExpType = Optional.ofNullable(new ImpExpType());
	
			impExpType = impExpTypeRepository.findById(impExpTypeId);
			
		return impExpType.get().getCausalList();
		
	}
	
	@Override
	public Iterable<Causal> getAllCausals() {
		
		return  repository.findAll();
	}

	@Override
	public Iterable<Instruction> getAllInstructionsByCausalId(Long id) throws CausalException {
		
		Causal causalFound = new Causal();
		causalFound= getCausalById(id);
		
		return causalFound.getInstructionList();

	}

	@Override
	public Causal createCausal(Causal causal) throws CausalException {
		 causal = repository.save(causal);
		return causal;
	}

	@Override
	public Causal getCausalById(Long id) throws CausalException {
		
		return repository.findById(id).orElseThrow(() -> new CausalException("El Id de la empresa no existe."));
	}

	@Override
	public Causal updateCausal(Causal causal) throws  CausalException {
		Calendar today = Calendar.getInstance(); 
		
		  Causal causeUpdated = getCausalById(causal.getId());
		  
		  
		 if(causeUpdated != null )
		  { 
			 System.out.println("Causal por actualizar "  + causeUpdated.toString());
			 mapCausal(causal,causeUpdated);
			 causeUpdated.setUpdated(today);
		     
			 causeUpdated = repository.save(causeUpdated);
		     
		     System.out.println("Empresa actualizada " + causeUpdated.toString());
		  
		  }else { 
			  throw new CausalException("La causal " + causal.getId() + "  no está disponible para actualizar"); }
		  
		  return causeUpdated;
	}

	@Override
	public void deleteCausal(Long id) throws CausalException {
		 Causal causeUpdated = getCausalById(id);
		if (causeUpdated != null) {
			repository.deleteById(id);
			
			
		}else {
			throw new CausalException("La causal " + id + "  no está disponible para eliminar");
		}
		
	}

	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapCausal(Causal from,Causal to) {
		
		to.setCausalClasification(from.getCausalClasification());
		to.setCausalCumplimiento(from.getCausalCumplimiento());
		to.setCausalDescription(from.getCausalDescription());
		to.setCausalExclusiva(from.getCausalExclusiva());
		to.setCausalFraction(from.getCausalFraction());
		to.setCausalOsCe(from.getCausalOsCe());
		to.setCausalType(from.getCausalType());
		to.setCreated(from.getCreated());
		to.setInstructionList(from.getInstructionList());
		to.setUpdated(from.getUpdated());
		

	}


	
	
}
