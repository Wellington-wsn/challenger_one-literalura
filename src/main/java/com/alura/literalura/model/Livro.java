package com.alura.literalura.model;

public class Livro {
    private String titulo;
    private String autor;
    private String idioma;
    private Integer NumerosDeDownloads;

    public Livro(String titulo, String autor, String idioma, Integer numerosDeDownloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.NumerosDeDownloads = numerosDeDownloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumerosDeDownloads() {
        return NumerosDeDownloads;
    }

    public void setNumerosDeDownloads(Integer numerosDeDownloads) {
        NumerosDeDownloads = numerosDeDownloads;
    }


}
