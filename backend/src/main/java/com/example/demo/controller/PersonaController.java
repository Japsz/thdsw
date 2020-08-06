package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Persona;


public interface PersonaController {
	public List<Persona> getPersonas();


	public Optional<Persona> getPersonaById(Long id);


	public Persona addPersona(Persona persona);


	public String deletePersona(Long id);


	public String updatePersona(Persona personaNew);


	public String test();
}

