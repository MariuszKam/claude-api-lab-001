package dev.claudefoundations.lab;

public class MissingApiKeyException extends RuntimeException {
    public MissingApiKeyException(String message) {
        super(message);
    }
}
