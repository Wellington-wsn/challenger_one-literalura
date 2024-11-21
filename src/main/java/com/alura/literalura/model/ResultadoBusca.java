package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadoBusca(
        @JsonProperty("count") Integer total,
        @JsonProperty("results") List<DadosLivro> resultados
) { }
