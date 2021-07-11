package com.api.livrosmarvel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.livrosmarvel.dtos.LivroDto;
import com.api.livrosmarvel.entities.Livro;
import com.api.livrosmarvel.services.LivroService;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

	@Autowired
	LivroService livroService;
	

	@PostMapping("/Cadastrar")
	public ResponseEntity<Livro> Cadastrar(@RequestBody Livro livro) {
		try {
			
			if (!(livro.getComicId() > 0)) {
				return ResponseEntity.badRequest().build();
			}

			Livro obj = livroService.MontarObjetoParaInsercao(livro.getComicId());
			obj = livroService.Cadastrar(obj);
			return ResponseEntity.created(null).body(obj);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping(value = "/BuscarPorUsuario/{idUsuario}")
	public ResponseEntity<List<Livro>> BuscarPorUsuario(@PathVariable Long idUsuario) {
		try {
			List<Livro> obj = livroService.BuscarPorUsuario(idUsuario);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping
	public ResponseEntity<List<LivroDto>> BuscarTodos() {
		try {
			List<LivroDto> list = livroService.MontarListaComDesconto();
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping(value = "/BuscarPorId/{id}")
	public ResponseEntity<Livro> BuscarPorId(@PathVariable Long id) {
		try {
			Livro obj = livroService.BuscarPorId(id);
			return ResponseEntity.ok().body(obj);
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
		

	}

}
