package com.alura.literalura.principal;

import com.alura.literalura.model.*;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivrosRepository;
import com.alura.literalura.service.ConsumoApi;
import com.alura.literalura.service.ConsumoJson;

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
            
            --- Menu:
                1 - Busca de livros pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros em um determinado idioma
                
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
                    listarAutoresVivosNoAno();
                    break;

                case 5:
                    listarLivrosPeloIdioma();
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

        livroBusca = repositorio.findByTituloContainingIgnoreCase(titulo);

        if (livroBusca.isPresent()) {
            System.out.println(livroBusca.get());
            return;
        }

        System.out.printf("Não foi encontrado o titulo: %s, no banco de dados!%n", titulo);
        System.out.print("Deseja buscar na web? (S/N): ");
        String resposta = leitura.nextLine().trim().toUpperCase();

        if (!resposta.equals("S")) {
            System.out.println("Busca cancelada pelo usuário.");
            return;
        }

       dadosLivros = pegarDadosLivro(titulo);

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

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.printf("\n*** LISTA DE LIVROS ENCONTRADOS  - TOTAL = %s ***\n", livros.size());
            livros.forEach(l -> System.out.printf("Titulo: %s, autor: %s - Idioma: %s%n",
                            l.getTitulo(),
                            l.getAutor().getNome(),
                            l.getIdioma()));
        }
    }

    private void listarAutores() {
        autores = autorRepositorio.findAll();

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado!");
        } else {
            System.out.println("\n*** LISTA DE AUTORES ENCONTRADOS ***");
            autores.forEach(a ->  System.out.printf("Nome: %s%n",
                            a.getNome()));
        }
    }

    private void listarAutoresVivosNoAno() {
        System.out.print("Digite o ano para verificar autores vivos: ");
        int ano = leitura.nextInt();

        autores = autorRepositorio.findByAnoFalecimentoIsNullOrAnoFalecimentoGreaterThan(ano);

        System.out.println("\n*** LISTA DE AUTORES ENCONTRADOS ***");
        autores.forEach(a ->  System.out.printf("Nome: %s, Data de Falecimento: %s%n",
                        a.getNome(),
                        a.getAnoFalecimento() != null ? a.getAnoFalecimento() : "Ainda vivo"));

    }

    private void listarLivrosPeloIdioma() {
        System.out.print("Digite o idioma para buscar os livros: ");
        String idiomaStr = leitura.next();

        Idioma idioma;

        try {
            idioma = Idioma.fromNome(idiomaStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        livros = repositorio.findByIdioma(idioma);

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o idioma: " + idioma.name());
        } else {
            System.out.printf("\n*** LISTA LIVROS NO IDIOMA %S ENCONTRADOS - QUANTIDADE %s ***\n", idioma.name(), livros.size());
            livros.forEach(l ->  System.out.printf("Titulo: %s, autor: %s - idioma: %s%n",
                            l.getTitulo(),
                            l.getAutor().getNome(),
                            l.getIdioma()));
        }

    }

}
