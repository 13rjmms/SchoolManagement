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

import com.codeforge.schoolmanagement.model.User;
import com.codeforge.schoolmanagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		List<User> users= new ArrayList<User>();
		userRepo.findAll().forEach(User -> users.add(User));
		return users;
	}

	public User getUserById(Integer id) {
		Optional<User> obj = userRepo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found! Id: " + id + ", Type: " + User.class.getName(), obj));
	}

	public User saveUser(User user) {
		user.setId(null); 
		return userRepo.save(user);
	}

	public User updateUser(User user) {
		User newUser = getUserById(user.getId());
		updateData(newUser, user);
		return userRepo.save(user);
	}

	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}

	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepo.findAll(pageRequest);
	}
	
	private void updateData(User newObj, User obj) {
	}

}
