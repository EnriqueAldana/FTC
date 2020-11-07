/**
 * 
 */
package com.cucoex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cucoex.entity.User;
import com.cucoex.service.IUserService;
import com.cucoex.service.UserServiceImpl;
import com.cucoex.util.Utileria;

/**
 * @author enrique
 *
 */
@SpringBootTest
class CuCoEx_Test {
	

	@Autowired
	IUserService userService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Test
	void crearusuarioTest() {
		//fail("Not yet implemented");

		
		
		User user = new User();
		User insertedUser = new User();
		user.setUsername("Jesus");
		user.setFirstName("Aldana");
		user.setLastName("Sanchez");
		user.setEmail("jeas196455@gmail.com");
		String pass = passwordEncoder.encode("1234");
		user.setPassword(pass);
		user.setConfirmPassword(pass);
		user.setCreated(Utileria.getCalendarToday());
		user.setLastUpdated(Utileria.getCalendarToday());
		
		try {
			insertedUser = userService.createUser(user);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		assertTrue(insertedUser.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
