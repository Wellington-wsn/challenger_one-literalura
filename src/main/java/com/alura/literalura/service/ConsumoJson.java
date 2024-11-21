package com.alura.literalura.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumoJson implements IConsumoJson {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T consumoJson(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
