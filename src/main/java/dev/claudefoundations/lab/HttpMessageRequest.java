package dev.claudefoundations.lab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.claudefoundations.lab.dto.MessageRequest;

import java.net.URI;
import java.net.http.HttpRequest;

public final class HttpMessageRequest {

    private static final URI MESSAGE_ENDPOINT = URI.create("https://api.anthropic.com/v1/messages");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static HttpRequest buildRequest(MessageRequest messageRequest) {
        return HttpRequest.newBuilder()
                .uri(MESSAGE_ENDPOINT)
                .header(HttpHeader.CONTENT_TYPE.getValue(), "application/json")
                .header(HttpHeader.ANTHROPIC_VERSION.getValue(), "2026-10-21")
                .header(HttpHeader.AUTHORIZATION.getValue(), "Bearer " + EnvironmentConfig.getAnthropicApiKey())
                .POST(HttpRequest.BodyPublishers.ofString(mapMessage(messageRequest)))
                .build();
    }

    private static String mapMessage(MessageRequest messageRequest) {
        try {
            return OBJECT_MAPPER.writeValueAsString(messageRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
