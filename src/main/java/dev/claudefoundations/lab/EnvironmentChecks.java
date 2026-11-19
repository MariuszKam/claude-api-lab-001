package dev.claudefoundations.lab;

public final class EnvironmentChecks {
    private EnvironmentChecks() {}

    public static boolean hasApiKey() {
        return isConfigured(System.getenv("ANTHROPIC_API_KEY"));
    }

    static boolean isConfigured(String value) {
        return value != null && !value.isBlank()
                && !value.equals("replace-with-your-own-key");
    }
}
