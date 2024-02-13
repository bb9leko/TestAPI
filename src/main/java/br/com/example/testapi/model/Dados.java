package br.com.example.testapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(
        @JsonAlias("codigo") Integer codigo,
        @JsonAlias("nome") String name) {


    /*@Override
    public String toString() {
        return "Codigo: " + codigo + " Nome: " + nome ;
    }*/
}
