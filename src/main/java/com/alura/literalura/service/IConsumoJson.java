package com.alura.literalura.service;

public interface IConsumoJson {
    <T> T cosumoJson(String json, Class<T> classe);
}
