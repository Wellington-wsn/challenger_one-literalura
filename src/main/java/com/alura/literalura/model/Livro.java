package com.alura.literalura.model;

public class Livro {
    private String titulo;
    private String autor;
    private Idioma idioma;
    private Integer NumerosDeDownloads;



    public Livro() {    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.autor = dadosLivro.autor();
        this.idioma = Idioma.fromString(dadosLivro.idioma().split(",")[0].trim());
        this.NumerosDeDownloads = dadosLivro.NumerosDeDownloads();
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

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getNumerosDeDownloads() {
        return NumerosDeDownloads;
    }

    public void setNumerosDeDownloads(Integer numerosDeDownloads) {
        NumerosDeDownloads = numerosDeDownloads;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", NumerosDeDownloads=" + NumerosDeDownloads;
    }
}
