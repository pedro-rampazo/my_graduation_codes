package br.edu.ifsp.aluno.api;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifsp.aluno.model.SerieResponse;

public class SerieApiTest {
    
    @Test
    void createObjectSerieApi() {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/series";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new SeriesApi(apiUrl, apiKey, hash);
        Assertions.assertNotNull(api);
    }

    @Test
    void listingAllSeries() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/series";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new SeriesApi(apiUrl, apiKey, hash);
        SerieResponse response = api.listSeries();

        Assertions.assertEquals(200, response.getCode());
        Assertions.assertEquals("f299c19c51d0fb4c1524af4475a9c3aea4415fbe", response.getEtag());
        Assertions.assertEquals(13553, response.getData().getTotal());
    }

    @Test
    void searchingSeriesById() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/series";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new SeriesApi(apiUrl, apiKey, hash);
        SerieResponse response = api.searchByIdSerie(31445);

        Assertions.assertEquals(31445, response.getData().getEvents().get(0).getId());
        Assertions.assertEquals(" Fantastic Four by Dan Slott Vol. 1 (2021)", response.getData().getEvents().get(0).getTitle());
    }

}
