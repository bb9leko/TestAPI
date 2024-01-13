package br.com.example.testapi.principal;

import br.com.example.testapi.model.DadosSerie;
import br.com.example.testapi.model.DadosTemporada;
import br.com.example.testapi.service.ApiConsumer;
import br.com.example.testapi.service.DataConvert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();
    private DataConvert convert = new DataConvert();
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=2765d4cc";
    public void exibeMenu() {

        System.out.println("Digite o nome da serie: ");
        var nomeSerie = leitura.nextLine();
        var json = consumer.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        System.out.println(json);

        DadosSerie dadosSerie = convert.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);

        DadosTemporada dadosTemporada = convert.obterDados(json, DadosTemporada.class);
        System.out.println(dadosTemporada);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1 ; i <= dadosSerie.totalTemporadas(); i++) {
            json = consumer.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +
                    "&season=" + i + APIKEY);
            DadosTemporada dados = convert.obterDados(json, DadosTemporada.class);
            temporadas.add(dados);
        }
        temporadas.forEach(System.out::println);

    }



}
