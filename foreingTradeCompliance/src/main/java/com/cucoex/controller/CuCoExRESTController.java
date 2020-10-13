/**
 * 
 */
package com.cucoex.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Member;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cucoex.dto.CausalCompliance;
import com.cucoex.dto.EmptyJsonResponse;
import com.cucoex.dto.ComplianceJSON;
import com.cucoex.dto.Dashboard;
import com.cucoex.entity.Causal;
import com.cucoex.entity.Company;
import com.cucoex.entity.Compliance;
import com.cucoex.entity.ImpExpType;
import com.cucoex.entity.Instruction;
import com.cucoex.entity.Status;
import com.cucoex.entity.User;
import com.cucoex.exception.CausalException;
import com.cucoex.exception.CompanyException;
import com.cucoex.exception.ComplianceException;
import com.cucoex.service.CausalService;
import com.cucoex.service.CausalServiceImpl;
import com.cucoex.service.CompanyService;
import com.cucoex.service.ComplianceService;
import com.cucoex.service.DashboardServiceImpl;
import com.cucoex.service.UserService;
import com.cucoex.util.StatusKey;
import com.cucoex.util.Utileria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.var;

import com.cucoex.repository.StatusRepository;
import com.cucoex.schedule.ScheduledTasks;

/**
 * @author enrique
 *
 */
@RestController
public class CuCoExRESTController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CuCoExRESTController.class);
    
	
	@Autowired
	CausalServiceImpl causalService;
	
	@Autowired
	CompanyService companyService;
	@Autowired
	ComplianceService complianceService;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	DashboardServiceImpl DashboradService;
	
	@GetMapping(value = "impExpTypes/{companyId}")
    public Company impExpTypes(@PathVariable Long companyId) {
		Company ret = null;
		
		Company companyFounded = new Company();
		try {
			companyFounded = companyService.getCompanyById(companyId);
		
			if (!companyFounded.equals(null)) {
				ret= companyFounded;
			}
			
			
		} catch (CompanyException e1) {
			
			log.error(e1.getMessage());
		}
		return ret;

      
    }
	
	
	@GetMapping(value = "getCompliance/{companyId}/{impExpTypeId}/{causalId}")
    public Compliance getCompliance(@PathVariable(name ="companyId")Long companyId, @PathVariable(name ="impExpTypeId")Long impExpTypeId, @PathVariable(name ="causalId")Long causalId)throws Exception{
		Compliance ret = null;
		
		Company companyFounded = new Company();
		companyFounded.setId(companyId);
		ImpExpType impExpTypeFounded = new ImpExpType();
		impExpTypeFounded.setId(impExpTypeId);
		Compliance complianceFounded = new Compliance();
		Causal causalFounded = new Causal();
		CausalCompliance causalCompliance= new CausalCompliance();
		
		
		causalFounded = causalService.getCausalById(causalId);
		//Set<Instruction> items = causalFounded.getInstructionList();	 
		//java.util.List<Instruction> instructionSorted = items.stream().collect(Collectors.toList());	
		//Collections.sort(instructionSorted, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		//causalFounded.setInstructionList(Utileria.convertListToSet(instructionSorted));
		Iterable<Compliance> complianceList=null;
		complianceList= complianceService.getAllComplianceByCompanyAndImpExtTypeAndCausal(companyFounded, impExpTypeFounded, causalFounded);
		if(((ArrayList<Compliance>) complianceList).size() > 0  ) {
			complianceFounded = complianceList.iterator().next();
			if (complianceFounded.getStatus().getStatusKey().equals("CUMP")) {
				complianceFounded.setIsCompliance(true);
			}else 
			{
				complianceFounded.setIsCompliance(false);
			}
			
		}
		
		return complianceFounded;

      
    }
	

	@GetMapping(value = "getDashboardData")
    public Dashboard getDashboard()throws Exception{
		Dashboard ret = new Dashboard();;
		
		Long totalCausal=0L;
		Long totalCausalCompliance=0L;
		Long totalCausalNonCompliance=0L;
		Long percentageCompliance=0L;
		Long totalCausalesXIncumplir=0L;
		// ToDo . Aqui bajar la Id del usuario logeado TODO
		User user= new User();
		user = userService.getUserById(1L);
		if(null != user) {
			totalCausal=DashboradService.getTotalCausalsByUserId(user.getId());
			totalCausalCompliance= DashboradService.getTotalCausalsComplianceByUserIdAndStatus(user.getId(),StatusKey.CUMP.toString());
			totalCausalesXIncumplir= DashboradService.getTotalCausalsComplianceByUserIdAndStatus(user.getId(),StatusKey.XINCUM.toString());
			totalCausalNonCompliance = DashboradService.getTotalCausalsComplianceByUserIdAndStatus(user.getId(),StatusKey.INCUM.toString());
			percentageCompliance = (100 * (totalCausalCompliance + totalCausalesXIncumplir)) / totalCausal ;
			ret.setTotalCausals(totalCausal);
			ret.setTotalCausalCompliance(totalCausalCompliance);
			ret.setTotalCausalesXIncumplir(totalCausalesXIncumplir);
			ret.setTotalCausalNonCompliance(totalCausalNonCompliance);
			ret.setPorcentajeCumplimiento(percentageCompliance);
			
		}
		
		
		
		return ret;

      
    }
	
		
	@GetMapping(value = "getInstructionList/{causalId}")
    public Set<Instruction> getInstructionListe(@PathVariable(name ="causalId")Long causalId)throws Exception{
		
		Causal causalFounded = new Causal();
		
		causalFounded = causalService.getCausalById(causalId);
		
		
		return causalFounded.getInstructionList();

      
    }
	 
	

	

	@PostMapping(path="/editAssignedCausal", consumes = "application/x-www-form-urlencoded")
	public ResponseEntity<String> postEditCausalForm(@RequestParam Map<String, String> bodyr) {
		 
		
		ResponseEntity<String> ret; 
		
		//	
		  
		if(!bodyr.isEmpty()) {
			
			 Map.Entry<String,String> entry = bodyr.entrySet().iterator().next();
			 String key = entry.getKey();
			 String value = entry.getValue();
			
			 ObjectMapper mapper = new ObjectMapper();
			 ComplianceJSON compliance=null;
			 Compliance complianceFounded = new Compliance();
			 Status status = new Status();
			 Calendar calendar = Calendar.getInstance();
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			 
			 
				try {
					 compliance = mapper.readValue(key, ComplianceJSON.class);
				} catch (IOException e) {
					
					log.error(e.getMessage());
					ret = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
					return ret;
				}
		
				try {
					complianceFounded = complianceService.getComplianceById(Long.parseLong(compliance.getId()));
					if 	(null != complianceFounded) {
						if ("3".equals(compliance.getStatusId())) {
							status= statusRepository.findByStatusKey("INCUM");
							
						}else {
							status= statusRepository.findByStatusKey("CUMP");
						}
						Date hoy = new Date();
						Date complianceEvaluationDate=Utileria.convertStringToDate("dd-MM-yyyy", compliance.getComplianceEvaluationDate());
								
						Date effectiveDateForCompliance = Utileria.convertStringToDate("dd-MM-yyyy", compliance.getEffectiveDateForCompliance());

						complianceFounded.setStatus(status);
						Calendar localDateEffectiveDateForCompliance= Utileria.dateToCalendar(effectiveDateForCompliance);		
						Calendar localDateComplianceEvaluationDate= Utileria.dateToCalendar(complianceEvaluationDate);
						
						complianceFounded.setEffectiveDateForCompliance(localDateEffectiveDateForCompliance);
						complianceFounded.setComplianceEvaluationDate(localDateComplianceEvaluationDate);
						complianceFounded.setUpdated(Utileria.dateToCalendar(hoy));
						complianceService.updateCompliance(complianceFounded);
						
						// Mandar llamar al monitor para que actualice estatus en funcion de las fechas
						complianceService.updateComplianceStatusByCompliance(complianceFounded);
						
					}	
					
				} catch (NumberFormatException | ComplianceException e) {
					
					log.error(e.getMessage());
					ret = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
					return ret;
				}
				
			
			
			ret = new ResponseEntity<>("success", HttpStatus.OK);
			
		}else {
			 ret = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST); 
		}
		
		System.out.println(ret.toString());
		return ret;
		
	}
	
	
	@RequestMapping(value = "/cucoexLogo", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage() throws IOException {

		ClassPathResource imgFile =  new ClassPathResource("/static/img/CuCoEx_logo.jpg");

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body( new InputStreamResource(( imgFile).getInputStream()));
    }
	/**
	 * 
	 */
	public CuCoExRESTController() {
		
	}

}
