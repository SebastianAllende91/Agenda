package com.test.prueba1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.prueba1.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
