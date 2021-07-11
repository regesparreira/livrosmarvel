package com.api.livrosmarvel.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.livrosmarvel.dtos.LivroDto;
import com.api.livrosmarvel.entities.Livro;
import com.api.livrosmarvel.repositories.LivroRepository;
import com.api.livrosmarvel.restservices.RestService;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	RestService restService;

	public List<Livro> Listar() {
		return livroRepository.findAll();
	}

	public Livro BuscarPorId(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.get();
	}

	public List<Livro> BuscarPorUsuario(Long idUsuario) {
		List<Livro> livrosBd = livroRepository.findAll();
		List<Livro> livros = new ArrayList<>();

		for (Livro livro : livrosBd) {
			if (livro.getUsuario().getId() == idUsuario) {
				livros.add(livro);
			}
		}
		return livros;
	}

	public Livro Cadastrar(Livro livro) {		
		return livroRepository.save(livro);
	}

	public Livro MontarObjetoParaInsercao(int comicId) {
		String json = restService.BuscarComicsApiMarvel(comicId);
		System.out.print(json);
		return new Livro();
	}

	public List<LivroDto> MontarListaComDesconto() {
		List<Livro> livros = Listar();
		List<LivroDto> livrosDto = new ArrayList<>();

		for (Livro livro : livros) {
			LivroDto livroDto = new LivroDto();

			livroDto.setComicId(livro.getComicId());
			livroDto.setTitulo(livro.getTitulo());
			livroDto.setPreco(livro.getPreco());
			livroDto.setAutores(livro.getAutores());
			livroDto.setIsbn(livro.getIsbn());
			livroDto.setDescricao(livro.getDescricao());
			livroDto.setUsuario(livro.getUsuario());
			
			String[] listaCodigos = livro.getIsbn().split("");
			String codigoFinal = listaCodigos[listaCodigos.length];

			if (codigoFinal.equals("0") || codigoFinal.equals("1")) {
				livroDto.setDiaSemanaDesconto("Segunda-Feira");
				livroDto.setDescontoAtivo(DayOfWeek.MONDAY == LocalDate.now().getDayOfWeek());

			} else if (codigoFinal.equals("2") || codigoFinal.equals("3")) {
				livroDto.setDiaSemanaDesconto("Terça-Feria");
				livroDto.setDescontoAtivo(DayOfWeek.TUESDAY == LocalDate.now().getDayOfWeek());

			} else if (codigoFinal.equals("4") || codigoFinal.equals("5")) {
				livroDto.setDiaSemanaDesconto("Quarta-Feira");
				livroDto.setDescontoAtivo(DayOfWeek.WEDNESDAY == LocalDate.now().getDayOfWeek());

			} else if (codigoFinal.equals("6") || codigoFinal.equals("7")) {
				livroDto.setDiaSemanaDesconto("Quinta-Feira");
				livroDto.setDescontoAtivo(DayOfWeek.THURSDAY == LocalDate.now().getDayOfWeek());

			} else {
				livroDto.setDiaSemanaDesconto("Sexta-Feira");
				livroDto.setDescontoAtivo(DayOfWeek.FRIDAY == LocalDate.now().getDayOfWeek());

			}

			if (livroDto.isDescontoAtivo()) {
				double valorDesconto = (livroDto.getPreco() - 10) / 100;
				livroDto.setPreco(livroDto.getPreco() - valorDesconto);
			}
			
			livrosDto.add(livroDto);
		}
		
		return livrosDto;
	}
}
