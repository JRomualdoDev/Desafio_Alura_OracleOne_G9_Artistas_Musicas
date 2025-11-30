package com.alura.desafio.desafioaluraoracleone.principal;

import com.alura.desafio.desafioaluraoracleone.model.Artista;
import com.alura.desafio.desafioaluraoracleone.model.Musica;
import com.alura.desafio.desafioaluraoracleone.model.enums.TipoArtista;
import com.alura.desafio.desafioaluraoracleone.service.ArtistaService;
import com.alura.desafio.desafioaluraoracleone.service.MusicaService;

import java.util.Optional;
import java.util.Scanner;

public class Menu {

    private final ArtistaService artistaService;
    private final MusicaService musicaService;

    public Menu(ArtistaService artistaService,  MusicaService musicaService) {
        this.artistaService = artistaService;
        this.musicaService = musicaService;
    }

    Scanner sc = new Scanner(System.in);
    
    public void execute() {
        
        while(true) {

            System.out.println("1 - Cadastrar artista");
            System.out.println("2 - Cadastrar música");
            System.out.println("3 - Buscar artista");
            System.out.println("4 - Buscar música");
            System.out.println("0 - sair");
            
            String option = sc.nextLine();
            
            switch (option) {
                case "1":
                    cadastrarArtista("");
                    break;
                case "2":
                    cadastrarMusica();
                    break;
                case "3":
                    buscarArtista();
                    break;
                case "4":
                    buscarMusica();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção não existente");
            }
        }
    }

    public void cadastrarArtista(String author) {

        String nome = "";

        if (author.isEmpty()) {
            System.out.println("Digite o nome do artista: ");
            nome = sc.nextLine();
        } else {
            nome = author;
        }

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

            if (musicaArtista.equalsIgnoreCase("Sair")) {
                break;
            }

            Musica musica = new Musica();
            musica.setTitulo(musicaArtista);
            artista.addMusica(musica);
        }

        String artistaSave = artistaService.save(artista);

        mensagemHelper(artistaSave);
    }

    private void cadastrarMusica() {

        System.out.println("Digite o nome do author da música:");
        String author = sc.nextLine();

        String musica = musicaService.save(author);

        if (musica.equals("Author não encontrado")) {
            System.out.println("Deseja Cadastrar o author? ");
            System.out.println("1 - sim | Qualquer tecla para voltar ao menu anterior : ");
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("1")) {
                cadastrarArtista(author);
            }

        } else {
            mensagemHelper(musica);
        }

    }

    private void buscarArtista() {

        System.out.println("Digite o nome do artista:");
        String art = sc.nextLine();

        Artista artista = artistaService.findByNome(art);

        if (artista == null) {
            art = "Artista inexistente";
            mensagemHelper(art);
            return;
        }

        Artista artistaAux = artistaService.findByNomeComMusicas(art);

        System.out.println("");
        System.out.println("*".repeat(50));
        System.out.println("Nome: " + artistaAux.getNome());
        System.out.println("Tipo: " + artistaAux.getTipo());
        System.out.println("Descrição: " + artistaAux.getDescricao());
        System.out.println("*".repeat(50));
        artistaAux.getMusicas().forEach(
                m -> {
                    System.out.println("Id: " + m.getId() + "," + " Titulo: " + m.getTitulo());
                });
        System.out.println("*".repeat(50));
        System.out.println("");
        System.out.println("Digite qualquer tecla para prosseguir");
        sc.nextLine();
    }

    private void buscarMusica() {

        System.out.println("Digite o nome da música:");
        String musica = sc.nextLine();

        Musica musica = musicaService.findMusicaByNome(musica);

    }

    private void mensagemHelper(String mensagem) {
        System.out.println("");
        System.out.println("#".repeat(50));
        System.out.println(" ".repeat(12) + mensagem);
        System.out.println("#".repeat(50));
        System.out.println("");
    }
}
