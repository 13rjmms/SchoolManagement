package com.codeforge.schoolmanagement.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codeforge.schoolmanagement.dto.TeacherDTO;
import com.codeforge.schoolmanagement.model.Role;
import com.codeforge.schoolmanagement.model.Teacher;
import com.codeforge.schoolmanagement.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findRoleById(@PathVariable Integer id) {
		Teacher teacher = teacherService.getRoleById(id);
		return ResponseEntity.ok().body(teacher);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertRole(@Valid @RequestBody Teacher teacher){
	Teacher obj = teacher;
	obj = teacherService.saveRole(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateRole(@Valid @RequestBody Teacher teacher, @PathVariable Integer id) {
		Teacher obj = teacher;
		obj.setId(id);
		obj = teacherService.updateRole(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
		teacherService.deleteRole(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<TeacherDTO>> findAll() {
		List<Teacher> list = teacherService.getAllRoles();
		List<TeacherDTO> listDTO = list.stream().map(obj -> new TeacherDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Teacher>> findPage(
			@RequestParam(defaultValue="0") Integer page, 
			@RequestParam(defaultValue="24") Integer linesPerPage, 
			@RequestParam(defaultValue="nome") String orderBy, 
			@RequestParam(defaultValue="ASC") String direction) {
		Page<Teacher> list = teacherService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
