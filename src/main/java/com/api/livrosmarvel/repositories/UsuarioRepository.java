package com.api.livrosmarvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.livrosmarvel.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {	
	
}
