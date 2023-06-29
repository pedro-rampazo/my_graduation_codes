package br.edu.ifsp.aluno.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiRequest {
    private String apiUrl;
    private String apiKey;
    private String hash;
    private HttpClient client;
    private ObjectMapper mapper;

    public ApiRequest(String api_url, String apiKey, String hash) {
        this.apiUrl = api_url;
        this.apiKey = apiKey;
        this.hash = hash;
        this.client = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper();
    }

    public HttpRequest generateRequest(URI uri) {
        return HttpRequest.newBuilder()
            .uri(uri)
            .GET()
            .header("Content-Type", "application/json")
            .build();
    }

    public HttpResponse<String> getResponse(HttpRequest request) throws IOException, InterruptedException {
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public HttpClient getClient() {
        return client;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }   
    
}
