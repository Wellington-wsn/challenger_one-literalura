package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.DadosLivro;
import com.alura.literalura.model.Livro;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConsumoJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Aplicacao {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConsumoJson conversor = new ConsumoJson();
    private final String ENDERECO = "http://gutendex.com/books/";

    private List<DadosLivro> dadosLivros = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private Optional<Livro> livroBusca;

    public void exibirMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
            Menu:
                1 - Busca de livros por título
                2 - Listagem de todos os livros
                3 - Lista de autores
                4 - Lista de autores vivos em determinado ano
                
                0 - Sair
            
            Escolha uma opção:
            """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;

                case 2:
                    listarLivros();
                    break;

                case 3:
                    listarAutores();
                    break;

                case 4:
                    System.out.print("Digite o ano para verificar autores vivos: ");
                    int ano = leitura.nextInt();
                    listarAutoresVivosEmAno(ano);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        leitura.close();
    }

    private DadosLivro pegarDadosLivro(String titulo) {
        var json = consumo.obterJson(ENDERECO+"?search="+titulo.replace(" ", "%20"));
        DadosLivro objetolivro = conversor.cosumoJson(json, DadosLivro.class);
        return objetolivro;
    }

    private void buscarLivroPorTitulo() {
        System.out.print("Digite o título do livro a ser buscado: ");
        String titulo = leitura.nextLine();

        DadosLivro dados = pegarDadosLivro(titulo);
        dadosLivros.add(dados);

        /*para repositorio
        Livro livro = new Livro(dados);
        repositorio.save(livro);*/

        System.out.println(dadosLivros);
    }

    private void listarLivros() {

        System.out.println(dadosLivros);
    }

    private void listarAutores() {

    }

    private void listarAutoresVivosEmAno(int ano) {

    }

}
