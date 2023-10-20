package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class HttpStatusChecker {

    public static final String GET_URL = "https://http.cat/<CODE>.jpg";
    private static final Integer NOT_FOUND_SC = 404;

    public String getStatusImage(int number) throws Exception {
        String uri = format(number);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(new URI(uri))
                .build();
        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(
                httpRequest,
                HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

       if (httpResponse.statusCode() == NOT_FOUND_SC){
           throw new HttpIncorectStatusCodeEx();
       }
       return uri;
    }
    public String format(int code){
        return GET_URL.replace("<CODE>", String.valueOf(code));
    }
}
