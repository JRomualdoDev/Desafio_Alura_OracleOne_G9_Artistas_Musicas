package com.alura.desafio.desafioaluraoracleone.repository;

import com.alura.desafio.desafioaluraoracleone.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNome(String nome);

    @Query("SELECT a FROM Artista a LEFT JOIN FETCH a.musicas WHERE a.nome = :nome")
    Optional<Artista> findByNomeComMusicas(String nome);
}
