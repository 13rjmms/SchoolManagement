package com.codeforge.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforge.schoolmanagement.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
