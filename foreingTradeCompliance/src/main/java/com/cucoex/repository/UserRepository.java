/**
 * 
 */
package com.cucoex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cucoex.entity.User;

import java.util.Optional;


/**
 * @author enrique
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public Optional<User> findByUsername(String username);
	public Optional<User> findByEmail(String email);
	public Optional<User> findByUsernameAndEmail(String username, String email);
	public Optional<User> findById(String username);

}
