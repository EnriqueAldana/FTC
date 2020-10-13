package com.cucoex.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.cucoex.schedule.ScheduledTasks;



@Controller
public class HomeController {
	
	 
	 
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(HomeController.class);
    
    
	// Inicio de la aplicacion mosyrando el tablero
	@GetMapping({"/"})
	public String index(Model model) {
		
		
		
		return "index";
		//return "home";
	}
	
	@GetMapping({"/dashboard"})
	public String dashboard(Model model) {
		
	
		
		return "index";
		//return "home";
	}
	
	
	@GetMapping({"/login","/login.html"})
	public String login() {
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


