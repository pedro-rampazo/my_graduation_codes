package br.edu.ifsp.aluno.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import br.edu.ifsp.aluno.model.ApiRequest;
import br.edu.ifsp.aluno.model.EventResponse;

public class EventsApi extends ApiRequest {
    
    public EventsApi(String apiUrl, String apiKey, String hash) {
        super(apiUrl, apiKey, hash);
    }

    public EventResponse listEvents() throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), EventResponse.class);
    }

    public EventResponse searchByTitleEvent(String eventTitle) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "?name=" + eventTitle + "&ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), EventResponse.class);
    }

    public EventResponse searchByIdEvent(int eventId) throws IOException, InterruptedException {
        URI uri = URI.create(getApiUrl() + "/" + eventId + "?ts=1&apikey=" + getApiKey() + "&hash=" + getHash());

        HttpRequest request = generateRequest(uri);

        HttpResponse<String> response = getResponse(request);

        return getMapper().readValue(response.body(), EventResponse.class);
    }

}
