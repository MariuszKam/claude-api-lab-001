package dev.claudefoundations.lab;

public enum HttpHeader {

    CONTENT_TYPE("Content-Type"),
    ANTHROPIC_VERSION("anthropic-version"),
    AUTHORIZATION("Authorization");

    private final String value;

    HttpHeader(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
