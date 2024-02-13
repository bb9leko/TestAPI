package br.com.example.testapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IDataConvert {
    //Generics
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;

    <T> List<T> obterLista(String json, Class<T> classe);


}
