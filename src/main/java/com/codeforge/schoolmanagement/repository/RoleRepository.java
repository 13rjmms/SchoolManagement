package com.codeforge.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforge.schoolmanagement.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
