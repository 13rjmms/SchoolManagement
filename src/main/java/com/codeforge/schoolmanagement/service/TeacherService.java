package com.codeforge.schoolmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.codeforge.schoolmanagement.model.Role;
import com.codeforge.schoolmanagement.model.Teacher;
import com.codeforge.schoolmanagement.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepo;

	public List<Teacher> getAllRoles() {
		List<Teacher> teachers= new ArrayList<Teacher>();
		teacherRepo.findAll().forEach(Teacher -> teachers.add(Teacher));
		return teachers;
	}

	public Teacher getRoleById(Integer id) {
		Optional<Teacher> obj = teacherRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! Id: " + id + ", Type: " + Role.class.getName(), obj));
	}

	public Teacher saveRole(Teacher teacher) {
		teacher.setId(null); 
		return teacherRepo.save(teacher);
	}

	public Teacher updateRole(Teacher teacher) {
		Teacher newTeacher = getRoleById(teacher.getId());
		updateData(newTeacher, teacher);
		return teacherRepo.save(teacher);
	}

	public void deleteRole(int id) {
		teacherRepo.deleteById(id);
	}

	public Page<Teacher> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return teacherRepo.findAll(pageRequest);
	}
	
	private void updateData(Teacher newObj, Teacher obj) {
	}

}
