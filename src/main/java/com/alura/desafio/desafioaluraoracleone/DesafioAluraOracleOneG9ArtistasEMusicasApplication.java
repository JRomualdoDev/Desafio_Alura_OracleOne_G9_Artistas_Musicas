package com.alura.desafio.desafioaluraoracleone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.desafio.desafioaluraoracleone.principal.Menu;

@SpringBootApplication
public class DesafioAluraOracleOneG9ArtistasEMusicasApplication implements CommandLineRunner {

    private final Menu menu;

    public DesafioAluraOracleOneG9ArtistasEMusicasApplication(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioAluraOracleOneG9ArtistasEMusicasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menu.execute();
    }
}
