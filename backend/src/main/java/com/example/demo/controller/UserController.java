package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.User;
import com.example.demo.requests.AddUser;
import com.example.demo.entities.Empleado;


public interface UserController {
	public List<User> getUsers();


	public Optional<User> getUserById(Long id);


	public User addUser(AddUser user);


	public String deleteUser(Long id);


	public String updateUser(User userNew);

	public User authUser(User authUser);

}

