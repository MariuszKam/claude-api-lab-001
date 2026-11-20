package dev.claudefoundations.lab;

import dev.claudefoundations.lab.dto.Message;
import dev.claudefoundations.lab.dto.MessageRequest;

public final class Main {
    private Main() {}

    static void main(String[] args) {
        if (EnvironmentConfig.hasApiKey()) {
            System.out.println("API KEY IS SET");
        } else {
            System.out.println("API KEY IS NOT SET");
            System.exit(2);
        }

        MessageRequest request = new MessageRequest(
                512,
                new Message[]{
                        new Message(
                                "Explain \"dependency injection\".\nUse a simple Java example.",
                                "user"
                        )
                },
                "claude-sonnet-4-6"
        );

    }

}
