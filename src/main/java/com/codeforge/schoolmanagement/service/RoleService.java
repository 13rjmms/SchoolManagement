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
import com.codeforge.schoolmanagement.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;

	public List<Role> getAllRoles() {
		List<Role> roles= new ArrayList<Role>();
		roleRepo.findAll().forEach(Role -> roles.add(Role));
		return roles;
	}

	public Role getRoleById(Integer id) {
		Optional<Role> obj = roleRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! Id: " + id + ", Type: " + Role.class.getName(), obj));
	}

	public Role saveRole(Role role) {
		role.setId(null); 
		return roleRepo.save(role);
	}

	public Role updateRole(Role role) {
		Role newRole = getRoleById(role.getId());
		updateData(newRole, role);
		return roleRepo.save(role);
	}

	public void deleteRole(int id) {
		roleRepo.deleteById(id);
	}

	public Page<Role> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return roleRepo.findAll(pageRequest);
	}
	
	private void updateData(Role newObj, Role obj) {
	}

}
