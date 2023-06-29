package br.edu.ifsp.aluno.api;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifsp.aluno.model.CharacterResponse;

public class CharacterApiTest {
    
    @Test
    void createObjectCharacterApi() {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/characters";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CharactersApi(apiUrl, apiKey, hash);
        Assertions.assertNotNull(api);
    }

    @Test
    void listingAllCharacters() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/characters";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CharactersApi(apiUrl, apiKey, hash);
        CharacterResponse response = api.listCharacters();

        Assertions.assertEquals(200, response.getCode());
        Assertions.assertEquals("dc24803e2587d622c9e86ad73c807497834ae293", response.getEtag());
        Assertions.assertEquals(1562, response.getData().getTotal());
    }

    @Test
    void searchingCharactersByName() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/characters";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CharactersApi(apiUrl, apiKey, hash);
        CharacterResponse response = api.searchByNameCharacter("Hulk");

        Assertions.assertEquals(1009351, response.getData().getCharacters().get(0).getId());
        Assertions.assertEquals("Hulk", response.getData().getCharacters().get(0).getName());
    }

    @Test
    void searchingCharacterById() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/characters";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new CharactersApi(apiUrl, apiKey, hash);
        CharacterResponse response = api.searchByIdCharacter(1009351);

        Assertions.assertEquals(1009351, response.getData().getCharacters().get(0).getId());
        Assertions.assertEquals("Hulk", response.getData().getCharacters().get(0).getName());
    }

}
