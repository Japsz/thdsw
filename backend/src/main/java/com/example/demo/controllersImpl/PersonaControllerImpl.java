package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.PersonaController;
import com.example.demo.entities.Persona;
import com.example.demo.service.PersonaService;


@RestController
public class PersonaControllerImpl implements PersonaController {
	@Autowired
	PersonaService personaService;


	// http://localhost:8888/personas (GET)
	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Persona> getPersonas() {
		return personaService.findAllPersonas();
	}


	// http://localhost:8888/personas/1 (GET)
	@Override
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Persona> getPersonaById(@PathVariable Long id) {
		return personaService.findPersonaById(id);
	}


	// http://localhost:8888/personas/add (ADD)
	@Override
	@RequestMapping(value = "/personas/add", method = RequestMethod.POST, produces = "application/json")
	public Persona addPersona(Persona persona) {
		return personaService.savePersona(persona);
	}


	// http://localhost:8888/personas/delete/1 (GET)
	@Override
	@RequestMapping(value = "/personas/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deletePersona(@PathVariable Long id) {
		return personaService.deletePersona(id);
	}


	// http://localhost:8888/personas/update (PATCH)
	@Override
	@RequestMapping(value = "/personas/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updatePersona(Persona personaNew) {
		return personaService.updatePersona(personaNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/personas/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
