package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public List<Persona> findAllPersonas() {
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findPersonaById(Long id) {
		Optional<Persona> persona = personaRepository.findById(id);
		return persona;
	}

	@Override
	public Persona savePersona(Persona newPersona) {
		if(newPersona != null) {
			return personaRepository.save(newPersona);
		}
		return new Persona();
	}

	@Override
	public String deletePersona(Long id) {
		if(personaRepository.findById(id).isPresent()) {
			personaRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}

	@Override
	public String updatePersona(Persona updatedPersona) {
		Long num = updatedPersona.getId();
		if(personaRepository.findById(num).isPresent()) {
			personaRepository.save(updatedPersona);
			return "Persona modificado correctamente";
		}
		return "Persona no existe en la BD";
	}
}
