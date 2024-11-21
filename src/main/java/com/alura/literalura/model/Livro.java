package com.alura.literalura.model;

import com.alura.literalura.repository.AutorRepository;
import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer NumerosDeDownloads;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Autor autor;

    public Livro() {    }

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.titulo();
        this.idioma = Idioma.fromString(dadosLivro.idiomas().get(0));
        this.NumerosDeDownloads = dadosLivro.NumerosDeDownloads();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
