package com.alura.desafio.desafioaluraoracleone.repository;

import com.alura.desafio.desafioaluraoracleone.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {

    Optional<Musica> findByTitulo(Musica musica);

}
