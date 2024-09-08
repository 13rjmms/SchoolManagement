package com.codeforge.schoolmanagement;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codeforge.schoolmanagement.model.Role;
import com.codeforge.schoolmanagement.model.User;
import com.codeforge.schoolmanagement.repository.RoleRepository;
import com.codeforge.schoolmanagement.repository.UserRepository;

@SpringBootApplication
public class SchoolManagementSystemApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role r1 = new Role(null, "ADMIN", "Administate the app" );
		Role r2 = new Role(null, "STUDENT", "Student from the scholl");
		
		User u1 = new User(null, "admin@gmail.com", "batata", true, r1);
		User u2 = new User(null, "student@gamilc.com", "limão", true, r2);
		
		roleRepo.saveAll(Arrays.asList(r1, r2));
		userRepo.saveAll(Arrays.asList(u1, u2));
		
	}

}
	