package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.UserController;
import com.example.demo.entities.Empleado;
import com.example.demo.entities.Persona;
import com.example.demo.entities.User;
import com.example.demo.requests.AddUser;
import com.example.demo.service.UserService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.PersonaService;


@RestController
public class UserControllerImpl implements UserController {
	@Autowired
	UserService userService;
	@Autowired
	EmpleadoService empleadoService;
	@Autowired
	PersonaService personaService;


	// http://localhost:8888/users (GET)
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<User> getUsers() {
		return userService.findAllUsers();
	}


	// http://localhost:8888/users/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}


	// http://localhost:8888/users/add (ADD)
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/users/add", method = RequestMethod.POST, produces = "application/json")
	public User addUser(@RequestBody AddUser req) {
		User newUser = new User();
		Empleado newEmpleado = new Empleado();
		Persona newPersona = new Persona();
		newUser.setUsername(req.username);
		newUser.setPassword(req.password);
		newUser.setType(req.type);

		User savedUser = userService.saveUser(newUser);
		newEmpleado.setId(savedUser.getId());
		newEmpleado.setCargo(req.cargo);
		newEmpleado.setDiasRestantes(10);
		newEmpleado.setUnidad(req.unidad);
		savedUser.setEmpleado(empleadoService.saveEmpleado(newEmpleado));

		newPersona.setNombre(req.name);
		newPersona.setId(savedUser.getId());
		savedUser.setPersona(personaService.savePersona(newPersona));

		return savedUser;
	}


	// http://localhost:8888/users/delete/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}


	// http://localhost:8888/users/update (PATCH)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/users/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateUser(@RequestBody User userNew) {
		return userService.updateUser(userNew);
	}


	// http://localhost:8888/auth (GET)
	@RequestMapping(value = "/users/auth", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:8081")
	@Override
	public User authUser(@RequestBody User user) {
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		System.out.println(user.getType());
		User authedUser = userService.authUser(user.getUsername(), user.getPassword());
		if(authedUser != null) {
			return authedUser;
		}
		return null;
	}
}
