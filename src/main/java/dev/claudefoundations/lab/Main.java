package dev.claudefoundations.lab;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.models.messages.Message;
import com.anthropic.models.messages.MessageCreateParams;

import java.util.Arrays;

public final class Main {
    private Main() {}

    public static void main(String[] args) {
        if (args.length == 0 || "--help".equals(args[0])) {
            System.out.println("Claude Developer Foundations Lab");
            System.out.println("Usage: gradlew run --args=\"--dry-run\"");
            System.out.println("       gradlew run --args=\"--ask Explain dependency injection\"");
            System.out.println("The --ask command makes a billable API request.");
            return;
        }
        if ("--dry-run".equals(args[0])) {
            System.out.println("Environment configured: " + EnvironmentChecks.hasApiKey());
            System.out.println("Dry run only. No network request was sent.");
            return;
        }
        if (!"--ask".equals(args[0]) || args.length < 2) {
            System.err.println("Expected --ask followed by a prompt, or --dry-run.");
            System.exit(2);
            return;
        }
        if (!EnvironmentChecks.hasApiKey()) {
            System.err.println("ANTHROPIC_API_KEY is missing. No request sent.");
            System.exit(2);
            return;
        }

        String prompt = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        String model = System.getenv().getOrDefault("ANTHROPIC_MODEL", "claude-opus-5-5");

        try {
            AnthropicClient client = AnthropicOkHttpClient.fromEnv();
            MessageCreateParams params = MessageCreateParams.builder()
                    .model(model)
                    .maxTokens(300L)
                    .addUserMessage(prompt)
                    .build();
            Message message = client.messages().create(params);
            System.out.println("stop_reason: " + message.stopReason());
            System.out.println("input_tokens: " + message.usage().inputTokens());
            System.out.println("output_tokens: " + message.usage().outputTokens());
            message.content().forEach(block ->
                    block.text().ifPresent(text -> System.out.println(text.text())));
            // Exercise: distinguish end_turn, max_tokens and tool_use safely.
        } catch (RuntimeException e) {
            System.err.println("Claude API request failed: " + e.getClass().getSimpleName());
            System.err.println("Check connectivity, credentials, limits and model availability.");
            System.exit(1);
        }
    }
}
