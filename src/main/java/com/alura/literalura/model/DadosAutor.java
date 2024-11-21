package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor (
        @JsonAlias({"name", "nome"}) String nome,
        @JsonAlias({"birth_year", "anoNascimento"}) Integer anoNascimento,
        @JsonAlias({"death_year", "anoFalecimento"}) Integer anoFalecimento

){ }
