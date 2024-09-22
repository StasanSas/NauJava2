package org.example.Tasks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

class Answer {
    @JsonProperty("user-agent")
    private String userAgent;

    public Answer() {
    }

    public String getUserAgent() {
        return userAgent;
    }
}

public class HTTPAndJSON {

    public static void printResult() throws IOException, InterruptedException {

        try (HttpClient client = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/user-agent"))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Answer answer = objectMapper.readValue(json, Answer.class);
                System.out.println(answer.getUserAgent());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
