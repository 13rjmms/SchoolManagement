package com.codeforge.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforge.schoolmanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
