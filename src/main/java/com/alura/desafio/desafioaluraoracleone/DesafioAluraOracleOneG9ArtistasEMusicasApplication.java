package com.alura.desafio.desafioaluraoracleone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.desafio.desafioaluraoracleone.principal.Menu;
import com.alura.desafio.desafioaluraoracleone.service.ArtistaService;

@SpringBootApplication
public class DesafioAluraOracleOneG9ArtistasEMusicasApplication implements CommandLineRunner {

    @Autowired
    private ArtistaService artistaService;

    public static void main(String[] args) {
        SpringApplication.run(DesafioAluraOracleOneG9ArtistasEMusicasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Menu menu = new Menu(artistaService);
        menu.execute();
    }
}
