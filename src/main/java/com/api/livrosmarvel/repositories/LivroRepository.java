package com.api.livrosmarvel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.livrosmarvel.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
