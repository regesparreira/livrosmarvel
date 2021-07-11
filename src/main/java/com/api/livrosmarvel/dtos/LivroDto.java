package com.api.livrosmarvel.dtos;


import java.util.Objects;

import com.api.livrosmarvel.entities.Usuario;

public class LivroDto {
	
	private int comicId;

	private String titulo;
	private double preco;
	private String autores;
	private String isbn;
	private String descricao;	
	private Usuario usuario;
	private boolean descontoAtivo;
	private String diaSemanaDesconto;
	
	
	
	public LivroDto() {
		super();
	}
	public LivroDto(int comicId, String titulo, double preco, String autores, String isbn, String descricao,
			Usuario usuario, boolean descontoAtivo, String diaSemanaDesconto) {
		super();
		this.comicId = comicId;
		this.titulo = titulo;
		this.preco = preco;
		this.autores = autores;
		this.isbn = isbn;
		this.descricao = descricao;
		this.usuario = usuario;
		this.descontoAtivo = descontoAtivo;
		this.diaSemanaDesconto = diaSemanaDesconto;
	}
	public int getComicId() {
		return comicId;
	}
	public void setComicId(int comicId) {
		this.comicId = comicId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean isDescontoAtivo() {
		return descontoAtivo;
	}
	public void setDescontoAtivo(boolean descontoAtivo) {
		this.descontoAtivo = descontoAtivo;
	}
	public String getDiaSemanaDesconto() {
		return diaSemanaDesconto;
	}
	public void setDiaSemanaDesconto(String diaSemanaDesconto) {
		this.diaSemanaDesconto = diaSemanaDesconto;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(autores, comicId, descontoAtivo, descricao, diaSemanaDesconto, isbn, preco, titulo,
				usuario);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroDto other = (LivroDto) obj;
		return Objects.equals(autores, other.autores) && Objects.equals(comicId, other.comicId)
				&& descontoAtivo == other.descontoAtivo && Objects.equals(descricao, other.descricao)
				&& Objects.equals(diaSemanaDesconto, other.diaSemanaDesconto) && Objects.equals(isbn, other.isbn)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(usuario, other.usuario);
	}
	

}
