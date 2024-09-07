package com.codeforge.schoolmanagement.dto;

import java.io.Serializable;

import com.codeforge.schoolmanagement.model.Role;
import com.codeforge.schoolmanagement.model.User;

public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private boolean isActive;
	private Role role;
	
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.isActive = user.isActive();
		this.role = user.getRole_id();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
