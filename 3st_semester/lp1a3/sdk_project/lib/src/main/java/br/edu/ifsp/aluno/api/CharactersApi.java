package br.edu.ifsp.aluno.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.edu.ifsp.aluno.model.ApiRequest;
import br.edu.ifsp.aluno.model.CharacterResponse;

public class CharactersApi extends ApiRequest {    

    public CharactersApi(String apiUrl, String apiKey, String hash) {
        super(apiUrl, apiKey, hash);
    }

    public CharacterResponse listCharacters() throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), CharacterResponse.class);
    }

    public CharacterResponse searchByNameCharacter(String characterName) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?name=" + characterName + "&ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), CharacterResponse.class);
    }

    public CharacterResponse searchByIdCharacter(int characterId) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "/" + characterId + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), CharacterResponse.class);
    }

}
