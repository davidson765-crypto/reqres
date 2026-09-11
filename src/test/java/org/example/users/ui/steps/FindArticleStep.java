package org.example.users.ui.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.example.ui.base.SelenideBaseClass;
import org.example.ui.pages.InitialPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FindArticleStep {

    @Given("пользователь открыл главную страницу wiki")
    public void openInitialPage() {
        SelenideBaseClass.openUrl(SelenideBaseClass.baseUri);
    }

    @When("пользователь перешел в русский раздел wiki")
    public void openMainPage() {
        new InitialPage().moveToLocalMainPage("ru");
    }

    @And("пользователь нашел статью, используя ключевое слово {string}")
    public void findArticle(String keyword) {
        $("#searchInput")
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled)
                .setValue(keyword)
                .pressEnter();
    }

    @Then("в заголовке найденной статьи содержиться слово {string}")
    public void checkArticleName(String articleName) {
        Assertions.assertThat($x("//span[@class='mw-page-title-main']").getText()).isEqualTo(articleName);
    }
}
