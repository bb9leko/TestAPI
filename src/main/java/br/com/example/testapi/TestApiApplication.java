package br.com.example.testapi;

import br.com.example.testapi.model.DadosSerie;
import br.com.example.testapi.model.DadosTemporada;
import br.com.example.testapi.service.ApiConsumer;
import br.com.example.testapi.service.DataConvert;
import ch.qos.logback.core.CoreConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ApiConsumer consumer = new ApiConsumer();
        var json = consumer.obterDados("http://www.omdbapi.com/?t=lupin&season=1&episode=1&apikey=2765d4cc");
        System.out.println(json);

        json = consumer.obterDados("https://coffee.alexflipnote.dev/random.json");
        System.out.println(json);

        DataConvert convert = new DataConvert();

        DadosSerie dados = convert.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        DadosTemporada temporada = convert.obterDados(json, DadosTemporada.class);
        System.out.println(temporada);

    }
}
