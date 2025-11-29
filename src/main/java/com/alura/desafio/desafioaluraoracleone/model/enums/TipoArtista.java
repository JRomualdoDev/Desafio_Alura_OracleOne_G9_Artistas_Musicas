package com.alura.desafio.desafioaluraoracleone.model.enums;

public enum TipoArtista {
    SOLO("Solo"),
    GRUPO("Grupo"),
    BANDA("Banda");

    private String categoriaArtista;

    TipoArtista(String categoriaArtista) {
        this.categoriaArtista = categoriaArtista;
    }

    public static TipoArtista fromString(String text) {
        for (TipoArtista b : TipoArtista.values()) {
            if (b.categoriaArtista.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Nenhuma tipo encontrado para este texto: " + text);
    }
}
