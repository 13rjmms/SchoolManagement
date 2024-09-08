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

import com.codeforge.schoolmanagement.dto.RoleDTO;
import com.codeforge.schoolmanagement.model.Role;
import com.codeforge.schoolmanagement.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> findRoleById(@PathVariable Integer id) {
		Role role = roleService.getRoleById(id);
		return ResponseEntity.ok().body(role);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertRole(@Valid @RequestBody Role role){
	Role obj = role;
	obj = roleService.saveRole(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateRole(@Valid @RequestBody Role role, @PathVariable Integer id) {
		Role obj = role;
		obj.setId(id);
		obj = roleService.updateRole(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
		roleService.deleteRole(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<RoleDTO>> findAll() {
		List<Role> list = roleService.getAllRoles();
		List<RoleDTO> listDTO = list.stream().map(obj -> new RoleDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Role>> findPage(
			@RequestParam(defaultValue="0") Integer page, 
			@RequestParam(defaultValue="24") Integer linesPerPage, 
			@RequestParam(defaultValue="nome") String orderBy, 
			@RequestParam(defaultValue="ASC") String direction) {
		Page<Role> list = roleService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
}
