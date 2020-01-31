package com.secondstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondstore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
