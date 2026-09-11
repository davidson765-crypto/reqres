package org.example.ui.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.example.ui.base.SelenideBaseClass.closeBrowser;
import static org.example.ui.base.SelenideBaseClass.openBrowser;

public class ExecutionHook implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) {
        closeBrowser();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        openBrowser();
    }
}
