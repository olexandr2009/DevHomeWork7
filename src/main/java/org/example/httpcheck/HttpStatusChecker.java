package org.example.httpcheck;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class HttpStatusChecker {

    private static final String GET_URL = "https://http.cat/%s.jpg";
    private static final Integer NOT_FOUND_SC = 404;

    public String getStatusImage(int number) throws Exception {
        String uri = formatCode(number);

        HttpRequest httpRequest;
        try {
            httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        if (httpResponse.statusCode() == NOT_FOUND_SC){
            throw new HttpIncorectStatusCodeEx();
        }
        return uri;
    }
    public String formatCode(int code){
        return String.format(GET_URL,code);
    }
}