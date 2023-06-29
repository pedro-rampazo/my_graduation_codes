package br.edu.ifsp.aluno.api;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifsp.aluno.model.ComicResponse;

public class ComicApiTest {
    
    @Test
    void createObjectComicApi() {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/comics";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new ComicsApi(apiUrl, apiKey, hash);

        Assertions.assertNotNull(api);
    }

    @Test
    void listingAllComics() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/comics";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new ComicsApi(apiUrl, apiKey, hash);
        ComicResponse response = api.listComics();

        Assertions.assertEquals(200, response.getCode());
        Assertions.assertEquals("aefcd20f06cb9e24cb4aa5c2b22ce597bb441e17", response.getEtag());
        Assertions.assertEquals(54905, response.getData().getTotal());
    }

    @Test
    void searchingComicById() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/comics";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new ComicsApi(apiUrl, apiKey, hash);
        ComicResponse response = api.searchByIdComic(1158);

        Assertions.assertEquals(1158, response.getData().getComics().get(0).getId());
        Assertions.assertEquals("0-7851-1129-8", response.getData().getComics().get(0).getIsbn());
    }

}
