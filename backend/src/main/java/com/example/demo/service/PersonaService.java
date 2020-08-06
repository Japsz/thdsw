package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Persona;

public interface PersonaService {
	public List<Persona> findAllPersonas();
	public Optional<Persona> findPersonaById(Long id);
	public Persona savePersona(Persona newPersona);
	public String deletePersona(Long id);
	public String updatePersona(Persona updatedPersona);
}
