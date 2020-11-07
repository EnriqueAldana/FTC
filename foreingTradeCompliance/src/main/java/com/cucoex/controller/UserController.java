package com.cucoex.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.Company;
import com.cucoex.entity.Role;
import com.cucoex.entity.User;
import com.cucoex.exception.CustomeFieldValidationException;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.RoleRepository;
import com.cucoex.schedule.ScheduledTasks;
import com.cucoex.service.CompanyService;
import com.cucoex.service.IUserService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {

	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);
   
	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	IUserService userService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Autowired BCryptPasswordEncoder bcrypt;
	
	// Cata,ogo de usuarios
	@GetMapping({"/users"})
	public String getUserList(HttpSession session,Authentication auth, Model model) {
		
		User user = (User) session.getAttribute(auth.getName());
		Iterable<User> userList = new ArrayList<User>();  
		Iterable<Company> companyList = new ArrayList<Company>(); 
		Collection<Role> roles = new ArrayList<Role>();
		
		  if (null != user) { 
			  try {
					companyList = userService.getAllCompaniesByUserRole(user);
					userList= userService.getAllUsersByUserRole(user);
					roles= userService.getAllRolesByUserRole(user);
					
				} catch (UsernameOrIdNotFound e1) {
					
					e1.printStackTrace();
				}
			  	 
		  }
		  
		  	model.addAttribute("userList",userList);
		  	model.addAttribute("companyList",companyList);
		  	model.addAttribute("roles",roles);
			model.addAttribute("editMode",false);
			model.addAttribute("passwordForm",new ChangePasswordForm());
			// Solo Admin y Superadmin dan de alta usuarios
			if(userService.isLoggedUserSUPERADMIN() || userService.isLoggedUserADMIN()) {
				model.addAttribute("allowToAdd",true);
			}
			
			baseAttributerForUserForm(model, new User(), TAB_LIST );
		return "user";
	}
	
	@GetMapping("/userFormIncluido")
	public String userFormIncluido(Model model) {
		baseAttributerForUserForm(model, new User(), TAB_LIST );
		return "user-form/user-view";
	}
	
	

	@GetMapping("/signup")
	public String signup(Model model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roles);
		return "user-form/user-signup";
	}
	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("userForm")User user, BindingResult result, ModelMap model) {
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
			return "user-form/user-signup";
		}else {
			try {
				userService.createUser(user);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return "redirect:/";
	}
	
	private void baseAttributerForUserForm(Model model, User user,String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute(activeTab,"active");
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		System.out.println("Entrando en userForm");
		baseAttributerForUserForm(model, new User(), TAB_LIST );
		return "user-form/user-form";
	}
	
	
	
	// Crear nuevo usuario
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
		}else {
			try {
				/*
				 * Date date = new Date(); Timestamp ts=new Timestamp(date.getTime());
				 */
				Calendar hoy = Calendar.getInstance();
				user.setCreated(hoy);
				user.setLastUpdated(hoy);
				String pass = bcrypt.encode(user.getPassword());
				user.setPassword(pass);
				user.setConfirmPassword(pass);
				userService.createUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST );
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM );
			}catch (Exception e) {
				// Esta excepcion es la que viene de la BD y no es amigable
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM );
			}
		}
		return "redirect:/users";
	}
	
	//@PreAuthorize("hasAnyRole('ROLE_SUPERADMIN','ROLE_ADMIN')")
	// esta validacion a ivel de metodo genera un error 4040 donde significa que el recurso no esta disponible o no existe
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(HttpSession session,Authentication auth,Model model, @PathVariable(name ="id")Long id)throws Exception{
	
		
		User user = (User) session.getAttribute(auth.getName());
		
		User userToEdit;
			userToEdit = userService.getUserById(id);
			

			Iterable<Company> companyList = new ArrayList<Company>(); 
			Collection<Role> roles = new ArrayList<Role>();
			
			  if (null != userToEdit) { 
				  try {
						companyList = userService.getAllCompaniesByUserRole(userToEdit);
						roles= userService.getAllRolesByUserRole(userToEdit);
						
					} catch (UsernameOrIdNotFound e1) {
						
						e1.printStackTrace();
					}
				  	 
			  }
			  
			  	model.addAttribute("companyList",companyList);
			  	model.addAttribute("roles",roles);
			
		model.addAttribute("editMode",true);
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
		// Solo Admin y Superadmin dan de alta usuarios
		if(userService.isLoggedUserSUPERADMIN() || userService.isLoggedUserADMIN()) {
			model.addAttribute("allowToAdd",true);
		}
		baseAttributerForUserForm(model, userToEdit, TAB_FORM );
		
		return "catUser/user-view";
		
 		
	}
	
	
	
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM );
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
		}else {
			try {
				Calendar hoy = Calendar.getInstance();
				user.setCreated(hoy);
				user.setLastUpdated(hoy);
				String pass = bcrypt.encode(user.getPassword());
				user.setPassword(pass);
				user.setConfirmPassword(pass);
				userService.updateUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST );
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				
				baseAttributerForUserForm(model, user, TAB_FORM );
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
			}
		}
		return "redirect:/users";
		
	}
	
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/users";

	}
	

	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Long id) {
		try {
		
			log.info("Borrando usuario " +id);
			userService.deleteUser(id);
		
		} 
		catch (UsernameOrIdNotFound uoin) {
			System.out.println();
			log.error("Excepcion al borrar usuario " +id);
			model.addAttribute("listErrorMessage",uoin.getMessage());
		}finally {
			model.addAttribute("userList", userService.getAllUsers());
			baseAttributerForUserForm(model, new User(), TAB_LIST );
		}
		
		return "redirect:/users";

	}
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
	
}