package com.cucoex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.Role;
import com.cucoex.entity.User;
import com.cucoex.exception.CustomeFieldValidationException;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.RoleRepository;
import com.cucoex.service.CompanyService;
import com.cucoex.service.UserService;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	RoleRepository roleRepository;
	
	
	// Cata,ogo de usuarios
	@GetMapping({"/users"})
	public String getUserList(Model model) {
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
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute("companyList",companyService.getAllCompanies());
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
		return "user";
	}
	

	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name ="id")Long id)throws Exception{
	
		User userToEdit;
			userToEdit = userService.getUserById(id);
			baseAttributerForUserForm(model, userToEdit, TAB_FORM );
		
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));

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
				
				userService.updateUser(user);
				baseAttributerForUserForm(model, new User(), TAB_LIST );
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				
				baseAttributerForUserForm(model, user, TAB_FORM );
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
			}
		}
		return "user";
		
	}
	
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/users";
		//return "user";
	}
	

	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Long id) {
		try {
			System.out.println("Borrando usuario " +id);
			userService.deleteUser(id);
		
		} 
		catch (UsernameOrIdNotFound uoin) {
			System.out.println("Excepcion al borrar usuario " +id);
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