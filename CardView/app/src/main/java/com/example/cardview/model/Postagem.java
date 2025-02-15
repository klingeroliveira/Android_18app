package com.example.cardview.model;

import android.graphics.drawable.Drawable;

import java.util.Date;

public class Postagem {

    private String autor;
    private Date data;
    private String legenda;
    private int imagem;

    public Postagem(String autor, Date data, String legenda, int imagem) {
        this.autor = autor;
        this.data = data;
        this.legenda = legenda;
        this.imagem = imagem;
    }

    public String getAutor() {
        return autor;
    }

    public Date getData() {
        return data;
    }

    public String getLegenda() {
        return legenda;
    }

    public int getImagem() {
        return imagem;
    }
}
