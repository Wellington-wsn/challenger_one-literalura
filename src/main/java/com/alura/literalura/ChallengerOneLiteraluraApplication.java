package com.alura.literalura;

import com.alura.literalura.principal.Aplicacao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengerOneLiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengerOneLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Aplicacao aplicacao = new Aplicacao();
		aplicacao.exibirMenu();
	}
}
