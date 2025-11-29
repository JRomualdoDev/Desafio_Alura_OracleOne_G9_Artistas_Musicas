package com.alura.desafio.desafioaluraoracleone.model;

import jakarta.persistence.*;
import com.alura.desafio.desafioaluraoracleone.model.enums.TipoArtista;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;

    private String descricao;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Musica> musicas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    // Método Helper
    public void addMusica(Musica musica) {
        musicas.add(musica);
        musica.setArtista(this);
    }
}
