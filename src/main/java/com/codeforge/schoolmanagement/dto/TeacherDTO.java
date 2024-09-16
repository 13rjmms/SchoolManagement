package com.codeforge.schoolmanagement.dto;

import java.io.Serializable;
import java.util.Date;

import com.codeforge.schoolmanagement.model.Teacher;

public class TeacherDTO implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Date birthDate;
	private String nationality;
	private String gender;
	private String observation;
	
	public TeacherDTO() {
	}
	
	public TeacherDTO(Teacher teacher) {
		this.id = teacher.getId();
		this.name = teacher.getName();
		this.birthDate = teacher.getBirthDate();
		this.nationality = teacher.getNationality();
		this.gender = teacher.getGender();
		this.observation = teacher.getObservation();
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
}
