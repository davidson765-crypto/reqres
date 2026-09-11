package org.example.ui.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.example.PropertyReadHelper;

public class SelenideBaseClass {

    public final static String baseUri = PropertyReadHelper.getPropertyCustom("OPTION_BASE_URI");

    public static void openBrowser() {
        Configuration.browser = PropertyReadHelper.getPropertyCustom("OPTION_BROWSER");
        Configuration.headless = Boolean.parseBoolean(PropertyReadHelper.getPropertyCustom("OPTION_HEADLESS"));
        Configuration.browserSize = PropertyReadHelper.getPropertyCustom("OPTION_BROWSER_SIZE");
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
    }

    public static void openUrl(String url) {
        Selenide.open(url);
    }

    public static void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
