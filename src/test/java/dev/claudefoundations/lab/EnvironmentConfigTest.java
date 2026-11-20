package dev.claudefoundations.lab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentConfigTest {
    @Test
    void rejectsMissingKey() {
        assertFalse(EnvironmentConfig.isConfigured(null));
        assertFalse(EnvironmentConfig.isConfigured("  "));
        assertFalse(EnvironmentConfig.isConfigured("replace-with-your-own-key"));
    }

    @Test
    void acceptsConfiguredValueWithoutPrintingIt() {
        assertTrue(EnvironmentConfig.isConfigured("example-placeholder-not-a-real-key"));
    }
}
