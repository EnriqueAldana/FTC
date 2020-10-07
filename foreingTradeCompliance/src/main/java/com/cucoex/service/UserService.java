package com.cucoex.service;



import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.User;
import com.cucoex.exception.UsernameOrIdNotFound;


public interface UserService {
	
	
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
}
