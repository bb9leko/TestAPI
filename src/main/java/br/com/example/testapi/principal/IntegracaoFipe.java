package br.com.example.testapi.principal;


import br.com.example.testapi.model.Dados;
import br.com.example.testapi.model.Modelos;
import br.com.example.testapi.service.ApiConsumer;
import br.com.example.testapi.service.DataConvert;

import java.util.Comparator;
import java.util.Scanner;

public class IntegracaoFipe {

    private Scanner leitura = new Scanner(System.in);
    private ApiConsumer consumer = new ApiConsumer();
    private DataConvert convert = new DataConvert();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1";

    public void exibeMenu() {

        var menu = """
                *** OPÇÕES ***
                Carro  
                Moto 
                Caminhão
                
                Digite uma das opções para consultar:                 
                """;

        System.out.println(menu);

        var tipoVeiculo = leitura.nextLine();

        String endereco = switch (tipoVeiculo.toLowerCase()) {
            case "carros" -> URL_BASE + "/carros/marcas";
            case "motos" -> URL_BASE + "/motos/marcas";
            case "caminhoes" -> URL_BASE + "/caminhoes/marcas";
            default -> throw new IllegalStateException("Invalid Option");
        };

        System.out.println(endereco);

        var json = consumer.obterDados(endereco);
        System.out.println(json);
        var newJson = json.replace("[", "").replace("]", " ");
        Dados dadosMarcas = convert.obterDados(newJson, Dados.class);
        System.out.println(dadosMarcas);

        var marcas = convert.obterLista(json, Dados.class);

        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe a marca desejada:");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumer.obterDados(endereco);

        System.out.println("\nModelos da marca selecionada:");
        var modeloLista = convert.obterDados(json, Modelos.class);
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);
    }
}
