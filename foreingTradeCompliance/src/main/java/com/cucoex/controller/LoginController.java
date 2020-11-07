package com.cucoex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cucoex.entity.User;
import com.cucoex.service.IUserService;
import com.cucoex.util.SessionKeyNames;

@Controller
//@RequestMapping("/private")
public class LoginController {
	@Autowired
	IUserService userService;
	
	
	@GetMapping("/index")
	public String index(Authentication auth, HttpSession session) {
		
		String username = auth.getName();
		if (session.getAttribute(username) == null) {
			try {
				User user = userService.getUserByUsername(username);
				user.setPassword(null);
				session.setAttribute(username, user);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return "index";
		
	}
	public LoginController() {
		
	}

}
