package br.edu.ifsp.aluno.api;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifsp.aluno.model.EventResponse;

public class EventApiTest {
    
    @Test
    void createObjectEventApi() {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/events";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new EventsApi(apiUrl, apiKey, hash);
        Assertions.assertNotNull(api);
    }

    @Test
    void listingAllEvents() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/events";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new EventsApi(apiUrl, apiKey, hash);
        EventResponse response = api.listEvents();

        Assertions.assertEquals(200, response.getCode());
        Assertions.assertEquals("ebd46c68888a434c6bab61e535dbe471a01bbb66", response.getEtag());
        Assertions.assertEquals(74, response.getData().getTotal());
    }

    @Test
    void searchingEventsByTitle() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/events";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new EventsApi(apiUrl, apiKey, hash);
        EventResponse response = api.searchByTitleEvent("Annihilation");

        Assertions.assertEquals(229, response.getData().getEvents().get(0).getId());
        Assertions.assertEquals("Annihilation", response.getData().getEvents().get(0).getTitle());
    }

    @Test
    void searchingEventById() throws IOException, InterruptedException {
        var apiUrl = "https://gateway.marvel.com:443/v1/public/events";
        var apiKey = "f6415d04b3defd3908c07d2c02c88516";
        var hash = "f4c2c921f82fa5a4f2ccdc7a2a13819d";
        var api = new EventsApi(apiUrl, apiKey, hash);
        EventResponse response = api.searchByIdEvent(229);

        Assertions.assertEquals(229, response.getData().getEvents().get(0).getId());
        Assertions.assertEquals("Annihilation", response.getData().getEvents().get(0).getTitle());
    }

}
