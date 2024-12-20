package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int anoNascimento;
    private  Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros = new ArrayList<>();


    public Autor() {    }

    public Autor(DadosAutor dataAutor) {
        this.nome = dataAutor.nome();
        this.anoNascimento = dataAutor.anoNascimento();
        this.anoFalecimento = dataAutor.anoFalecimento();
    }

    public Autor(Autor dadosAutor) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        if (anoNascimento <= 0) {
            throw new IllegalArgumentException("O ano de nascimento deve ser um valor positivo.");
        }
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        if (anoFalecimento != null && anoFalecimento <= this.anoNascimento) {
            throw new IllegalArgumentException("O ano de falecimento deve ser maior que o ano de nascimento.");
        }
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }


    public void setLivros(List<Livro> livros) {
        livros.forEach(a -> a.setAutor(this));
        this.livros = livros;
    }

    @Override
    public String toString() {
        return
                "***** AUTOR *****\n" +
                " autor: " + nome + "\n" +
                " anoNascimento: " + anoNascimento + "\n" +
                " anoFalecimento: " + anoFalecimento+ "\n" +
                "***************** \n\n";

    }
}
