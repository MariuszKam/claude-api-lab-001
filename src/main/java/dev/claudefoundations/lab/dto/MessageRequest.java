package dev.claudefoundations.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageRequest(@JsonProperty(value = "max_tokens")int maxTokens, Message[] messages, String model) {
}
