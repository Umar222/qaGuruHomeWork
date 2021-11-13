package ru.umar.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GitHubPage {

    SelenideElement issuePageLink = $(By.id("issues-tab"));
    SelenideElement issueLineContainer = $(By.id("js-repo-pjax-container"));

    @Step("Открыть страницу Issue")
    public GitHubPage openIssuePage(){
        issuePageLink.click();
        return this;
    }

    @Step("Проверить что на странице есть надпись {description}")
    public GitHubPage checkInscriptionOnPage(String text){
        issueLineContainer.shouldHave(Condition.text(text));
        return this;
    }
}
