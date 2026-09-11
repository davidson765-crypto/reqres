package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InitialPage {

    public MainPage moveToLocalMainPage(String lang) {
        String link = langsLinks.stream()
                .filter(x -> x.contains("js-link-box-" + lang))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unsupported language: " + lang
                ));

        $x(link)
                .shouldBe(Condition.visible)
                .click();

        return new MainPage();
    }

    List<String> langsLinks = List.of(
            "//a[@id='js-link-box-ru']",
            "//a[@id='js-link-box-en']",
            "//a[@id='js-link-box-de']",
            "//a[@id='js-link-box-zh']",
            "//a[@id='js-link-box-fr']",
            "//a[@id='js-link-box-es']",
            "//a[@id='js-link-box-ja']",
            "//a[@id='js-link-box-it']",
            "//a[@id='js-link-box-pl']",
            "//a[@id='js-link-box-pt']"
    );

    private final static By russianMainPage = By.xpath("//a[@id='js-link-box-ru']");
    private final static By englishMainPage = By.xpath("//a[@id='js-link-box-en']");
    private final static By deutschMainPage = By.xpath("//a[@id='js-link-box-de']");
    private final static By chineseMainPage = By.xpath("//a[@id='js-link-box-zh']");
    private final static By frenchMainPage = By.xpath("//a[@id='js-link-box-fr']");
    private final static By spanishMainPage = By.xpath("//a[@id='js-link-box-es']");
    private final static By japaneseMainPage = By.xpath("//a[@id='js-link-box-ja']");
    private final static By italianMainPage = By.xpath("//a[@id='js-link-box-it']");
    private final static By polishMainPage = By.xpath("//a[@id='js-link-box-pl']");
    private final static By portugalMainPage = By.xpath("//a[@id='js-link-box-pt']");
}
