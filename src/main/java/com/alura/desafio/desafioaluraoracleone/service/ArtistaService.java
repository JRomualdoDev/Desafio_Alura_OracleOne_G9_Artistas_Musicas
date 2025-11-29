package com.alura.desafio.desafioaluraoracleone.service;

import com.alura.desafio.desafioaluraoracleone.model.Artista;
import org.springframework.stereotype.Service;
import com.alura.desafio.desafioaluraoracleone.repository.ArtistaRepository;

import java.util.Optional;

@Service
public class ArtistaService {

    private ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public Artista save(Artista artista) {

        Optional<Artista> filtroExistArtista = artistaRepository.findByNome(artista.getNome());

        if (filtroExistArtista.isPresent()) {
            System.out.println("Artista já existente");
            return null;
        }

         return artistaRepository.save(artista);
    }

    public Artista findByNome(String nome) {

        Optional<Artista> artista = artistaRepository.findByNome(nome);
        return artista.orElse(null);
    }
}
