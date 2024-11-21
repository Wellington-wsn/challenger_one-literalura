package com.alura.literalura.principal;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivrosRepository;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConsumoJson;
import org.springframework.stereotype.Component;

import java.util.*;


public class Aplicacao {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConsumoJson conversor = new ConsumoJson();
    private final String ENDERECO = "http://gutendex.com/books/";

    private List<DadosLivro> dadosLivros = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private Optional<Livro> livroBusca;
    private LivrosRepository repositorio;
    private AutorRepository autorRepositorio;

    public Aplicacao(LivrosRepository repositorio, AutorRepository autorRepository) {
        this.repositorio = repositorio;
        this.autorRepositorio = autorRepository;
    }

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

    private List<DadosLivro> pegarDadosLivro(String titulo) {
        var json = consumo.obterJson(ENDERECO+"?search="+titulo.replace(" ", "%20"));

        ResultadoBusca jsonResult = conversor.consumoJson(json, ResultadoBusca.class);
        System.out.println(jsonResult);
        return jsonResult.resultados();
    }

    private void buscarLivroPorTitulo() {
        System.out.print("Digite o título do livro a ser buscado: ");
        String titulo = leitura.nextLine();

        List<DadosLivro> dadosLivros = pegarDadosLivro(titulo);

        for (DadosLivro dados : dadosLivros) {
            DadosAutor dadosAutor = dados.autores().get(0);

            Autor autorExistente = autorRepositorio.findByNome(dadosAutor.nome());

            Autor autor = (autorExistente != null) ? autorExistente : new Autor(dadosAutor);
            if (autorExistente == null) {
                autorRepositorio.save(autor);
            }

            Livro livro = new Livro(dados);
            livro.setAutor(autor);
            repositorio.save(livro);
        }
        System.out.println("Livros encontrados e salvos: " + dadosLivros.size());
    }

    private void listarLivros() {
        livros = repositorio.findAll();
        livros.forEach(System.out::println);
    }

    private void listarAutores() {

    }

    private void listarAutoresVivosEmAno(int ano) {

    }

}
