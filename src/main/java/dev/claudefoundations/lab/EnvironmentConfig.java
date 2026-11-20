package dev.claudefoundations.lab;

public final class EnvironmentConfig {

    private static final String ANTHROPIC_API_KEY = System.getenv("ANTHROPIC_API_KEY");

    private EnvironmentConfig() {}

    public static String getAnthropicApiKey() {
        if (hasApiKey()) {
            return ANTHROPIC_API_KEY;
        } else {
            throw new MissingApiKeyException("Missing Api Key");
        }
    }

    static boolean hasApiKey() {
        return isConfigured(ANTHROPIC_API_KEY);
    }

    static boolean isConfigured(String value) {
        return value != null && !value.isBlank()
                && !value.equals("replace-with-your-own-key");
    }
}
