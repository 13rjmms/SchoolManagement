package com.codeforge.schoolmanagement.dto;

import java.io.Serializable;

import com.codeforge.schoolmanagement.model.Role;

public class RoleDTO implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	public RoleDTO() {
	}
	
	public RoleDTO(Role role) {
		this.id = role.getId();
		this.name = role.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
