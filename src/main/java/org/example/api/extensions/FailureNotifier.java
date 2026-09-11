package org.example.api.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class FailureNotifier implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.println("❌ Тест упал: " + testName);
        System.out.println("Причина: " + cause.getMessage());

        sendNotification(testName, cause);
    }

    private void sendNotification(String testName, Throwable cause) {
        // логика уведомления
    }
}