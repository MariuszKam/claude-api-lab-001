package dev.claudefoundations.lab;

public final class Main {
    private Main() {}

    static void main(String[] args) {
        if (EnvironmentConfig.hasApiKey()) {
            System.out.println("API KEY IS SET");
        }
    }

}
