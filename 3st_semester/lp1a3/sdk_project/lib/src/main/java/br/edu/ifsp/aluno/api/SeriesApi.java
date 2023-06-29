package br.edu.ifsp.aluno.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.edu.ifsp.aluno.model.ApiRequest;
import br.edu.ifsp.aluno.model.SerieResponse;

public class SeriesApi extends ApiRequest {
    
    public SeriesApi(String apiUrl, String apiKey, String hash) {
        super(apiUrl, apiKey, hash);
    }

    public SerieResponse listSeries() throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), SerieResponse.class);
    }

    public SerieResponse searchByIdSerie(int serieId) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "/" + serieId + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), SerieResponse.class);
    }

}
