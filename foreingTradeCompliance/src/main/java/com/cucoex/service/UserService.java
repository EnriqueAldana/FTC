/**
 * 
 */
package com.cucoex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cucoex.entity.Role;
import com.cucoex.entity.UserPrincipal;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.util.RoleName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author enrique
 *
 */
@Service
public class UserService implements UserDetailsService{

	
	@Autowired
	private IUserService userRepo;
	
	/**
	 * 
	 */
	public UserService() {
		
	}

	
	  @Override 
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	  
			  UserDetails userDet = null; 
			  com.cucoex.entity.User foundedUser =null;
			  try { 
				  foundedUser = userRepo.getUserByEmail(email);
						  //userRepo.getUserByUsername(username);
				  
					  if (foundedUser != null) {
							/*
							 * List<GrantedAuthority> roles= new ArrayList(); Set grantList = new HashSet();
							 * for (Role role: foundedUser.getRoles()) { GrantedAuthority grantedAuthority =
							 * new SimpleGrantedAuthority(role.getDescription());
							 * grantList.add(grantedAuthority); }
							 */
							
						  userDet = UserPrincipal.build(foundedUser);
								  //new User(foundedUser.getUsername(),foundedUser.getPassword(),grantList);
					  }else {
						  throw new UsernameOrIdNotFound("Usuario no existe en el sistema");
					  }
				   
			  
			  }catch (Exception e) {  
				  e.printStackTrace();
			  }
			  
			  return userDet; 
	  }
	 

}
