/**
 * 
 */
package com.cucoex.controller;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cucoex.dto.AssignedCausalForm;
import com.cucoex.dto.ChangePasswordForm;
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
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.ComplianceRepository;
import com.cucoex.repository.StatusRepository;
import com.cucoex.repository.UserRepository;
import com.cucoex.schedule.ScheduledTasks;
import com.cucoex.service.CausalServiceImpl;
import com.cucoex.service.CompanyService;
import com.cucoex.service.ComplianceService;
import com.cucoex.service.ComplianceServiceImp;
import com.cucoex.service.ImpExpTypeService;
import com.cucoex.service.UserServiceImpl;
import com.cucoex.util.SessionKeyNames;

import antlr.collections.List;
import lombok.extern.log4j.Log4j2;


import lombok.extern.slf4j.Slf4j;


/**
 * @author enrique
 *
 */
@Controller
public class CausalController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(CausalController.class);
    
	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";

	@Autowired
	CausalServiceImpl causalService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	CompanyService companyService;
	
		
		@Autowired
		ComplianceServiceImp complianceServiceImp;

		@Autowired
		StatusRepository statusRepository;
	/**
	 * 
	 */
	public CausalController() {
		

	}
	
	
	
	  @GetMapping({"/assignedCausals"}) 
	  public String getAssignedCausalsList(HttpSession session,Authentication auth, Model model) {
	  
	  // Aqui va el numero de la empresa Asignada al usuario // TODO Auto-generated
		  // MAnejo de sessiones, Agregar al metodo el parametro HttpSession session ya que es un Mapping request
		  // Fijar datos en la session
		  // session.setAttribute(Constants.FOO, new Foo());
		    //...
		  // Obtener de la  session
		  //  Foo foo = (Foo) session.getAttribute(Constants.FOO);

	   log.info("Entrando a /assignedCausals" ); 
	  User user = (User) session.getAttribute(auth.getName());
	  
	  if (null != user) {
		  try {
		  		Company firstCompany = userService.getAllCompaniesByUser(user).stream().findFirst().get();
		  		model.addAttribute("companyList",userService.getAllCompaniesByUser(user));
			  	model.addAttribute("impexpTypeList",firstCompany.getImpExpTypeList());
				
			} catch (UsernameOrIdNotFound e) {
				
				e.printStackTrace();
			}
	  }
		  	
	  baseAttributerForAssignedCausalForm(model, new Causal(), TAB_LIST );
		  	
	  model.addAttribute("editMode","false");  	
	  return "assignedCausals";
	  }
	 
	
	
	@GetMapping("/editAssignedCausal/{companyId}/{impExpTypeId}/{causalId}")
	public String getEditCompanyForm(Model model, @PathVariable(name ="companyId")Long companyId, @PathVariable(name ="impExpTypeId")Long impExpTypeId, @PathVariable(name ="causalId")Long causalId)throws Exception{
	
		log.info("Entrando a /editCausal/{companyId}/{impExpTypeId}/{causalId} con Ids " + companyId.toString() + impExpTypeId.toString() + causalId.toString());
		Company companyToEdit;
		companyToEdit = companyService.getCompanyById(companyId);
		ImpExpType impExpTypeToEdit = new ImpExpType();
		impExpTypeToEdit.setId(impExpTypeId);
		Causal causalToEdit = new Causal();
		causalToEdit = causalService.getCausalById(causalId);
		Calendar calendario = Calendar.getInstance();
		
		model.addAttribute("causal",causalToEdit);
		
		
		Set<Instruction> items = causalToEdit.getInstructionList();
		 
		java.util.List<Instruction> instructionSorted = items.stream().collect(Collectors.toList());
		
		Collections.sort(instructionSorted, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		
		model.addAttribute("instructionList" , instructionSorted);
		
		// Traer el primer compliance por editar
		Compliance compliance = complianceServiceImp.getAllComplianceByCompanyAndImpExtTypeAndCausal(companyToEdit, impExpTypeToEdit, causalToEdit).iterator().next();
		compliance.setCausal(causalToEdit);
		compliance.setImpexptype(impExpTypeToEdit);
		if (compliance.getStatus().getStatusKey().equals("CUMP")) {
			compliance.setIsCompliance(true);
		}else 
		{
			compliance.setIsCompliance(false);
		}
		// Fijar formato a fechas
		
		  Format formatter; formatter = new SimpleDateFormat("dd-MM-yyyy");

		
		baseAttributerForAssignedCausalForm(model,  compliance,TAB_FORM);
		model.addAttribute("editMode","true");
		

		
		return "assignedCausals/assignedCausal-view";
		
 		
	}
	
	@GetMapping("/editAssignedCausal/cancel")
	public String cancelEditAssignedCausal(ModelMap model) {
		
		return "redirect:/assignedCausals";
	}
	
	

	
	private void baseAttributerForAssignedCausalForm(Model model, Compliance compliance,String activeTab) {
		model.addAttribute("complianceForm", compliance);
		model.addAttribute(activeTab,"active");
	}
	
	private void baseAttributerForAssignedCausalForm(Model model, Causal causal,String activeTab) {
		model.addAttribute("assignedCausalForm", causal);
		model.addAttribute(activeTab,"active");
	}
}
