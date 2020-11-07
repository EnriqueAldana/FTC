package com.cucoex.service;



import java.util.Collection;
import java.util.Set;

import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.Company;
import com.cucoex.entity.Role;
import com.cucoex.entity.User;
import com.cucoex.exception.UsernameOrIdNotFound;


public interface IUserService {
	
	
	public Iterable<User> getAllUsers();
	
	public Collection<User> getUsersAssignedToAdministrator(User user) throws UsernameOrIdNotFound;
	
	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User getUserByEmail(String email) throws Exception;
	
	public User getUserByUsername(String username) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
	
	public boolean isLoggedUserADMIN();
	
	public boolean isLoggedUserSUPERADMIN();

	public boolean loggedUserHasRole(String role);
	
	public Iterable<Company> getAllCompaniesByUserRole(User user) throws UsernameOrIdNotFound;
	
	public Iterable<User> getAllUsersByUserRole(User user)throws UsernameOrIdNotFound ;
	
	public Collection<Role> getAllRolesByUserRole(User user)throws UsernameOrIdNotFound;
	
}
