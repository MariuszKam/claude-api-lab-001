package dev.claudefoundations.lab;

import java.net.URI;
import java.net.http.HttpRequest;

public final class MessageRequest {

    private static final URI MESSAGE_ENDPOINT = URI.create("https://api.anthropic.com/v1/messages");

    public static HttpRequest buildRequest(String message) {
        return HttpRequest.newBuilder()
                .uri(MESSAGE_ENDPOINT)
                .header(HttpHeader.CONTENT_TYPE.getValue(), "application/json")
                .header(HttpHeader.ANTHROPIC_VERSION.getValue(), "2026-10-21")
                .header(HttpHeader.AUTHORIZATION.getValue(), "Bearer " + EnvironmentConfig.getAnthropicApiKey())
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();
    }
}
