package org.example.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ArticlePage {

    public final static SelenideElement articleBody = $x("//main[@id='content']");

    public String getText(SelenideElement element) {
        return element.getText();
    }
}
