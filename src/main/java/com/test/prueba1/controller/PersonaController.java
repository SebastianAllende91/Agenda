package com.test.prueba1.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.prueba1.models.Persona;
import com.test.prueba1.service.PersonaService;

@RestController
@CrossOrigin
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/contactos")
	public List<Persona> traerListado() {
		return this.personaService.getContacts();
	}

	@GetMapping("contactos/{id}")
	public Persona getUser(@PathVariable Long id) {
		try {
			return this.personaService.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No existe la persona con el 'Id' : " + id);
		}
		return null;
	}
	
	@PostMapping("contactos/save")
	public Persona addContact(@RequestBody Persona persona) {
		return this.personaService.addContact(persona);
	}
	
	@DeleteMapping("contactos/{id}")
	public Persona deleteContact(@PathVariable Long id) {
		try {
			return this.personaService.deleteContact(id);
		} catch (SQLException e) {
			System.out.println("No se puede eliminar la persona con el 'Id' : " + id);
			return null;
		}
	}


}
