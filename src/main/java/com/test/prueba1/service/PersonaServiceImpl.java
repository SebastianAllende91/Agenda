package com.test.prueba1.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.prueba1.models.Persona;
import com.test.prueba1.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> getContacts() {
		
		return personaRepository.findAll();
	}

	@Override
	public Persona findById(Long id) throws SQLException {
		Persona persona = new Persona();
		Optional<Persona>personaOptional = personaRepository.findById(id);
		
		if(personaOptional.isPresent()) {
			persona =personaOptional.get();
			System.out.println("Persona: " + persona.getApellido());
		}else {
			throw new SQLException();
		}
		
		return persona;
	}
	
	@Override
	public Persona addContact(Persona persona) {
		return this.personaRepository.save(persona);
	}

	@Override
	public Persona deleteContact(Long id) throws SQLException {
		Optional<Persona> personaOptional = personaRepository.findById(id);
		
		if(personaOptional.isPresent()) {
			this.personaRepository.deleteById(id);
			return personaOptional.get();
		}else {
			throw new SQLException();
			
		}
		
	}



}
