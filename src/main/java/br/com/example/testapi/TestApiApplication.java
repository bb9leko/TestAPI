package br.com.example.testapi;

import br.com.example.testapi.model.DadosEpisodio;
import br.com.example.testapi.model.DadosSerie;
import br.com.example.testapi.model.DadosTemporada;
import br.com.example.testapi.principal.Principal;
import br.com.example.testapi.service.ApiConsumer;
import br.com.example.testapi.service.DataConvert;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal();
        principal.exibeMenu();

        /*
        ApiConsumer consumer = new ApiConsumer();
        var json = consumer.obterDados("http://172.26.94.81:8080/ordem");
        System.out.println(json);
        var json = consumer.obterDados("http://www.omdbapi.com/?t=friends&apikey=2765d4cc");
        System.out.println(json);

        json = consumer.obterDados("https://coffee.alexflipnote.dev/random.json");
        System.out.println(json);

        DataConvert convert = new DataConvert();
        DadosSerie dados = convert.obterDados(json, DadosSerie.class);
        System.out.println(dados);

       // DadosTemporada temporada = convert.obterDados(json, DadosTemporada.class);
       // System.out.println(temporada);

        json = consumer.obterDados("http://www.omdbapi.com/?t=friends&season=1&episode=1&apikey=2765d4cc");
        DadosEpisodio episodio = convert.obterDados(json, DadosEpisodio.class);
        System.out.println(episodio);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1 ; i <= dados.totalTemporadas(); i++) {
            json = consumer.obterDados("http://www.omdbapi.com/?t=friends&season="+ i + "&apikey=2765d4cc");
            DadosTemporada dadosTemporada = convert.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);
        */
    }
}
