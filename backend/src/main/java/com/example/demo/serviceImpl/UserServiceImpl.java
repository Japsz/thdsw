package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Optional<User> findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	@Override
	public User saveUser(User newUser) {
		if(newUser != null) {
			return userRepository.save(newUser);
		}
		return new User();
	}
	
	@Override
	public String deleteUser(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}
	
	@Override
	public String updateUser(User updatedUser) {
		Long num = updatedUser.getId();
		if(userRepository.findById(num).isPresent()) {
			userRepository.save(updatedUser);
			return "User modificado correctamente";
		}
		return "User no existe en la BD";
	}
	@Override
	public User authUser(String username, String password) {
		List<User> users = userRepository.findByUsernameAndPassword(username, password);
		if(users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
