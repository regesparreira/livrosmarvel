package com.api.livrosmarvel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livrosmarvel.entities.Usuario;
import com.api.livrosmarvel.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> Listar() {
		return usuarioRepository.findAll();
	}

	public Usuario BuscarPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}

	public Usuario Cadastrar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
