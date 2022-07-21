package com.greatlearning.christy_restapiassignmentsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.christy_restapiassignmentsolution.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
