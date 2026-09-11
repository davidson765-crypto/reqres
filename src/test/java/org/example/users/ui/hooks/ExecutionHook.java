package org.example.users.ui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static org.example.ui.base.SelenideBaseClass.closeBrowser;
import static org.example.ui.base.SelenideBaseClass.openBrowser;

public class ExecutionHook {

    @Before
    public void beforeScenario() {
        openBrowser();
    }

    @After
    public void afterScenario() {
        closeBrowser();
    }
}
