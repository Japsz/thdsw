package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.UserController;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;


@RestController
public class UserControllerImpl implements UserController {
	@Autowired
	UserService userService;


	// http://localhost:8888/users (GET)
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<User> getUsers() {
		return userService.findAllUsers();
	}


	// http://localhost:8888/users/1 (GET)
	@Override
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}


	// http://localhost:8888/users/add (ADD)
	@Override
	@RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json")
	public User addUser(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return userService.saveUser(user);
	}


	// http://localhost:8888/users/delete/1 (GET)
	@Override
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}


	// http://localhost:8888/users/update (PATCH)
	@Override
	@RequestMapping(value = "/users/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateUser(User userNew) {
		return userService.updateUser(userNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/users/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
