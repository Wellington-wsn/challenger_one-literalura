package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") String autor,
        @JsonAlias("lenguages") String idioma,
        @JsonAlias("download_count") Integer NumerosDeDownloads
) { }
