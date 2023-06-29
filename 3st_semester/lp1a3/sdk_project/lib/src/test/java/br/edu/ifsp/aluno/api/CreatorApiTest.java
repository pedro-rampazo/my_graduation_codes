package br.edu.ifsp.aluno.api;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifsp.aluno.model.CreatorResponse;

public class CreatorApiTest {
    
    @Test
    void createObjectCreatorApi() {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/creators";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CreatorsApi(apiUrl, apiKey, hash);
        Assertions.assertNotNull(api);
    }

    @Test
    void listingAllCreators() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/creators";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CreatorsApi(apiUrl, apiKey, hash);
        CreatorResponse response = api.listCreators();

        Assertions.assertEquals(200, response.getCode());
        Assertions.assertEquals("931e48ddebcd71c0988b34695213c06036b96e00", response.getEtag());
        Assertions.assertEquals(5843, response.getData().getTotal());
    }

    @Test
    void searchingCreatorsByFirstName() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/creators";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CreatorsApi(apiUrl, apiKey, hash);
        CreatorResponse response = api.searchByFirstNameCreator("A.R.K.");

        Assertions.assertEquals(6606, response.getData().getCreators().get(0).getId());
        Assertions.assertEquals("A.R.K.", response.getData().getCreators().get(0).getFirstName());
    }

    @Test
    void searchingCreatorById() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/creators";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CreatorsApi(apiUrl, apiKey, hash);
        CreatorResponse response = api.searchByIdCreator(6606);

        Assertions.assertEquals(6606, response.getData().getCreators().get(0).getId());
        Assertions.assertEquals("A.R.K.", response.getData().getCreators().get(0).getFirstName());
    }

}
