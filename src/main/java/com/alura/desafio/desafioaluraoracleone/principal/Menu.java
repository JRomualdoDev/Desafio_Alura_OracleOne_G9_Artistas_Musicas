package com.alura.desafio.desafioaluraoracleone.principal;

import com.alura.desafio.desafioaluraoracleone.model.Artista;
import com.alura.desafio.desafioaluraoracleone.model.Musica;
import com.alura.desafio.desafioaluraoracleone.model.enums.TipoArtista;
import com.alura.desafio.desafioaluraoracleone.service.ArtistaService;

import java.util.Scanner;

public class Menu {

    private final ArtistaService artistaService;

    public Menu(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }

    Scanner sc = new Scanner(System.in);
    
    public void execute() {
        
        while(true) {

            System.out.println("1 - Cadastrar artista");
            System.out.println("2 - Cadastrar música");
            System.out.println("3 - Cadastrar música por artista");
            System.out.println("4 - sair");
            
            String option = sc.nextLine();
            
            switch (option) {
                case "1":
                    cadastrarArtista();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Opção não existente");
            }
        }
    }

    private void cadastrarArtista() {
        System.out.println("Digite o nome do artista: ");
        String nome = sc.nextLine();
        System.out.println("Digite o tipo do artista: ");
        String tipo = sc.nextLine();
        System.out.println("Digite uma descrição do artista: ");
        String descricao = sc.nextLine();

        Artista artista = new Artista();
        artista.setNome(nome);
        artista.setTipo(TipoArtista.fromString(tipo));
        artista.setDescricao(descricao);



        while(true) {
            System.out.println("Digite o nome da música do " + nome + " ou 'Sair' : ");
            String musicaArtista = sc.nextLine();

            if (musicaArtista.equals("Sair")) {
                break;
            }

            Musica musica = new Musica();
            musica.setTitulo(musicaArtista);
            artista.addMusica(musica);
        }
        try {
            artistaService.save(artista);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
