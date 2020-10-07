package com.cucoex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cucoex.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String string);

}
