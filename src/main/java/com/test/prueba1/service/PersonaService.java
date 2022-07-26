package com.test.prueba1.service;

import java.sql.SQLException;
import java.util.List;

import com.test.prueba1.models.Persona;

public interface PersonaService {
	// Devuelve una lista de contactos
	List<Persona>getContacts();
	
	// Encuentra un contato por su id
	Persona findById(Long id) throws SQLException;
	
	// Agregar un contacto
	Persona addContact(Persona persona);
	
	// Elimina un contacto por su id
	Persona deleteContact(Long id) throws SQLException;

}
