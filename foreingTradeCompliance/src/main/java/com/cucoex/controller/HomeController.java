package com.cucoex.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {
	
	
	// Inicio de la aplicacion mosyrando el tablero
	@GetMapping({"/","/index.html"})
	public String index(Model model) {
		
	
		
		return "login";
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
	
	
	 
	
}


