/**
 * 
 */
package com.cucoex.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cucoex.entity.Status;

/**
 * @author enrique
 *
 */
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
	
	Optional<Status> findById(Long id);
	Status findByStatusName(String name);
	Status findByStatusKey(String key);

}
