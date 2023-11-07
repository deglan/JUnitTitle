package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

@Slf4j
public class TestLoggingWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.error("Test nie przeszedł: {}", context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("Test zakończony sukcesem: {}", context.getDisplayName());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.warn("Test wyłączony: {}", context.getDisplayName());
    }
}
