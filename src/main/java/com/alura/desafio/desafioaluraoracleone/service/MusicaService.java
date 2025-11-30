package com.alura.desafio.desafioaluraoracleone.service;

import com.alura.desafio.desafioaluraoracleone.model.Artista;
import com.alura.desafio.desafioaluraoracleone.model.Musica;
import com.alura.desafio.desafioaluraoracleone.principal.Menu;
import com.alura.desafio.desafioaluraoracleone.repository.ArtistaRepository;
import com.alura.desafio.desafioaluraoracleone.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class MusicaService {

    private MusicaRepository musicaRepository;
    private ArtistaRepository artistaRepository;

    public MusicaService(MusicaRepository musicaRepository,  ArtistaRepository artistaRepository) {
        this.musicaRepository = musicaRepository;
        this.artistaRepository = artistaRepository;
    }

    public String save(String artista){

        Scanner sc = new Scanner(System.in);

        Optional<Artista> artistaOptional = artistaRepository.findByNome(artista);

        if (artistaOptional.isPresent()) {
            System.out.println("Digite o nome da música: ");
            String musicaAuthor = sc.nextLine();

            Musica musica = new Musica();
            musica.setTitulo(musicaAuthor);
            musica.setArtista(artistaOptional.get());
            musicaRepository.save(musica);

            return "Música salva com sucesso!";

        } else {
           return "Author não encontrado";
        }
    }

    public Musica findMusicaByNome(Musica musica) {

        Optional<Musica> musicaFiltro = musicaRepository.findByTitulo(musica);

        return musicaFiltro.orElse(null);

    }
}
