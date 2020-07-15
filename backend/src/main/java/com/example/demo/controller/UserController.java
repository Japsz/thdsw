package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.User;


public interface UserController {
	public List<User> getUsers();


	public Optional<User> getUserById(Long id);


	public User addUser(User user);


	public String deleteUser(Long id);


	public String updateUser(User userNew);


	public String test();
}

