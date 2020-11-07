package com.cucoex.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cucoex.entity.User;
import com.cucoex.schedule.ScheduledTasks;



@Controller
public class HomeController {
	
	 
	 
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);
    
    
	// Inicio de la aplicacion mosyrando el tablero
	@PreAuthorize("permitAll()")
	@GetMapping({"/","/init.html"})
	public String init(Model model) {
		
		
		
		return "init";
		//return "home";
	}
	
	@GetMapping({"/dashboard"})
	public String dashboard(Model model) {

		return "index";
		//return "home";
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping({"/login","/login.html"})
	public String login(Model model) {
		model.addAttribute("userLoginForm", new User());
		
		return "login";
	}
	
	@PostMapping("/loginUser")
	public String loginUser() {
		
		return "index";
	}
	
	@GetMapping({"/error"})
	public String error() {
		return "error";
	}
	 
	
}


