/**
 * 
 */
package com.cucoex.service;

import java.util.Calendar;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cucoex.dto.ChangePasswordForm;
import com.cucoex.entity.Company;
import com.cucoex.entity.User;
import com.cucoex.exception.CustomeFieldValidationException;
import com.cucoex.exception.UsernameOrIdNotFound;
import com.cucoex.repository.UserRepository;

/**
 * @author enrique
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	public Set<Company> getAllCompaniesByUser(User user) throws UsernameOrIdNotFound {
		
		User userfounded= new User();

			userfounded = getUserById(user.getId());
	
		
		return userfounded.getCompanies();
	}
	
	private boolean checkUsernameAvailable(User user) throws Exception {
		// Busca dispnible para nombre de usuario
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		// Optional<User> userFound = repository.findByUsernameAndEmail(user.getUsername(), user.getEmail());
		 //Optional<User> userFound = repository.findByEmail(user.getEmail());
		if (userFound.isPresent()) {
			
			//throw new CustomeFieldValidationException("Correo elec no disponible","email");
			throw new CustomeFieldValidationException("Nombre de usuario no disponible","username");
		}
		return true;
	}

	private boolean checkEmailAvailable(User user) throws Exception {
		// Busca dispnible para email de usuario
		
		 Optional<User> userFound = repository.findByEmail(user.getEmail());
		if (userFound.isPresent()) {
			throw new CustomeFieldValidationException("Correo elec no disponible","email");
			
		}
		return true;
	}
	
	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new CustomeFieldValidationException("Confirm Password es obligatorio","confirmPassword");
		}
		
		if ( !user.getPassword().equals(user.getConfirmPassword())) {
			throw new CustomeFieldValidationException("Password y Confirm Password no son iguales","password");
		}
		return true;
	}


	@Override
	public User createUser(User user) throws Exception {
		if ( checkEmailAvailable(user) && checkPasswordValid(user)) {
			//String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			//user.setPassword(user.getPassword());
			
			// Traer Empresas y seaterselas
			/*
			 * Set<Company> listaEmpresas = new
			 * HashSet<Company>((Collection<Company>)companyService.getAllComanies()); // it
			 * works!
			 * 
			 * if(!listaEmpresas.isEmpty()) { user.setCompanies(listaEmpresas); }
			 */
			
			user = repository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws UsernameOrIdNotFound {
		return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));
	}


	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from,User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
		to.setCompanies(from.getCompanies());
	}



	
	
	@Override
	public User changePassword(ChangePasswordForm form) throws Exception {
		User user = getUserById(form.getId());
		
	
		if( user.getPassword().equals(form.getNewPassword())) {
			throw new Exception ("Nuevo debe ser diferente al password actual.");
		}
		
		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
		}
		
		//String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setPassword(form.getNewPassword());
		return repository.save(user);
	}

	@Override
	// LA usamos cuando tengamos varias operaciones de escritura y actualizacion para obligar a que JPA actualice a la BD @Transactional
	// @Transactional
	public User updateUser(User user) throws UsernameOrIdNotFound {
		
		
		  Calendar hoy = Calendar.getInstance(); 
		  
		  User userUpdated = getUserById(user.getId());
		  
		  
		 if(userUpdated != null )
		  { 
			 System.out.println("Usuario por actualizar "  + userUpdated.toString());
			 mapUser(user,userUpdated);
             userUpdated.setLastUpdated(hoy);
		     userUpdated = repository.save(userUpdated);
		     
		     System.out.println("Usuario actualizada " + userUpdated.toString());
		  
		  }else { 
			  throw new UsernameOrIdNotFound("Id de Persona no disponible para actualizar"); }
		  
		  return userUpdated;
		 
	}

	@Override
	public void deleteUser(Long id) throws UsernameOrIdNotFound {
		
		// Busca dispnible para nombre de usuario.
		
		Optional<User> userFound = repository.findById(id);
				if (userFound.isPresent()) {
					repository.deleteById(id);
					
					
				}else {
					throw new UsernameOrIdNotFound("Nombre de usuario no disponible");
				}
				
		
 		
		
	}
	

	
	



}
