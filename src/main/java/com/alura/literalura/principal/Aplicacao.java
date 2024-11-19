package com.alura.literalura.principal;

import com.alura.literalura.model.DadosLivro;
import com.alura.literalura.model.Livro;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConsumoJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConsumoJson conversor = new ConsumoJson();
    private final String ENDERECO = "http://www.gutendex.com/books";

    private List<DadosLivro> dadosLivros = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();


}
