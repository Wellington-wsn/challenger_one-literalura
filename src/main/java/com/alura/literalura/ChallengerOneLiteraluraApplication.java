package com.alura.literalura;

import com.alura.literalura.principal.Aplicacao;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengerOneLiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivrosRepository repositorio;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengerOneLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Aplicacao aplicacao = new Aplicacao(repositorio, autorRepository);
		aplicacao.exibirMenu();
	}
}
