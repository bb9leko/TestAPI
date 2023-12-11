package br.com.example.testapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConvert implements IDataConvert {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe)  {
        try {
            return mapper.readValue(json, classe);
        }
        catch (JsonProcessingException e) {

            throw new RuntimeException(e);

        }
    }



}
