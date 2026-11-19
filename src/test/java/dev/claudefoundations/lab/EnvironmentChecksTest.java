package dev.claudefoundations.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentChecksTest {
    @Test
    void rejectsMissingKey() {
        assertFalse(EnvironmentChecks.isConfigured(null));
        assertFalse(EnvironmentChecks.isConfigured("  "));
        assertFalse(EnvironmentChecks.isConfigured("replace-with-your-own-key"));
    }

    @Test
    void acceptsConfiguredValueWithoutPrintingIt() {
        assertTrue(EnvironmentChecks.isConfigured("example-placeholder-not-a-real-key"));
    }
}
