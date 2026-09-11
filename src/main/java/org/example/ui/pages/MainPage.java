package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import org.example.PropertyReadHelper;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static final String pageUrlRu = PropertyReadHelper.getPropertyCustom("OPTION_RU_BASE_URI") + "/wiki/Заглавная_страница";

    public ArticlePage getArticle(int id) {
        $$x("//div[@class='main-wrapper']//div[contains(@class, 'main-bloc')]").get(id).$x(".//*[@class='main-cdx-button-link ']").$x(".//a").shouldBe(Condition.exist).click();

        return new ArticlePage();
    }

    public MainPage openHeaderSideMenu() {
        $x("//input[@id='vector-main-menu-dropdown-checkbox']").shouldBe(Condition.exist).click();

        return this;
    }

    public String getHeaderSideMenuBodyText() {
        return $x("//div[@id='vector-main-menu-dropdown']//div[@class='vector-dropdown-content']//div[@id='p-navigation']").shouldBe(Condition.visible).getText();
    }
}
