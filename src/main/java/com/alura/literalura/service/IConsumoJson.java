package com.alura.literalura.service;

public interface IConsumoJson {
    <T> T consumoJson(String json, Class<T> classe);
}
