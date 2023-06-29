package br.edu.ifsp.aluno.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.edu.ifsp.aluno.model.ApiRequest;
import br.edu.ifsp.aluno.model.ComicResponse;

public class ComicsApi extends ApiRequest {
    
    public ComicsApi(String apiUrl, String apiKey, String hash) {
        super(apiUrl, apiKey, hash);
    }

    public ComicResponse listComics() throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), ComicResponse.class);
    }

    public ComicResponse searchByIdComic(int comicId) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "/" + comicId + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), ComicResponse.class);
    }


}
