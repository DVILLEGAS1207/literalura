package com.example.literatura.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PeticionApi {
    private static final String URL_BASE = "https://gutendex.com/books";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public String obtenerDatos(String titulo) {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + "/?search=" + titulo.replace(" ", "+")))
                .build();

        try {
            var response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt(); // buena práctica en caso de InterruptedException
            throw new RuntimeException("Error al obtener datos de la API", e);
        }
    }
}

