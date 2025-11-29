package com.alura.desafio.desafioaluraoracleone.repository;

import com.alura.desafio.desafioaluraoracleone.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNome(String nome);
}
