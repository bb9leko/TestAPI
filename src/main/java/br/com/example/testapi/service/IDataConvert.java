package br.com.example.testapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IDataConvert {
    //Generics
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;

}
