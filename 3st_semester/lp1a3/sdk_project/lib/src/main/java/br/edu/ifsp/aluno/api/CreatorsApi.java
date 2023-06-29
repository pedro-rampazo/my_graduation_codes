package br.edu.ifsp.aluno.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.edu.ifsp.aluno.model.ApiRequest;
import br.edu.ifsp.aluno.model.CreatorResponse;

public class CreatorsApi extends ApiRequest{
    
    public CreatorsApi(String apiUrl, String apiKey, String hash) {
        super(apiUrl, apiKey, hash);
    }

    public CreatorResponse listCreators() throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), CreatorResponse.class);
    }

    public CreatorResponse searchByFirstNameCreator(String firstNameCreator) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?firstName=" + firstNameCreator + "&ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), CreatorResponse.class);
    }

    public CreatorResponse searchByIdCreator(int creatorId) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "/" + creatorId + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), CreatorResponse.class);
    }

}
