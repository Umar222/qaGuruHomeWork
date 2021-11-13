package ru.umar.allureTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ListenerTests {

    private final String ISSUE_TEXT = "Bad browser language in version 6+";

    @Test
    public void checkIssue(){
        SelenideLogger.addListener("AllureSelenide" ,new AllureSelenide());
        open("https://github.com/selenide/selenide");
        $(By.id("issues-tab")).click();
        $(By.id("js-repo-pjax-container")).shouldHave(Condition.text(ISSUE_TEXT));
    }

}
