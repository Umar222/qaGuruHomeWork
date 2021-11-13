package ru.umar.allureTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTests {

    private final String ISSUE_TEXT = "Bad browser language in version 6+";

    @Test
    public void lambdaTest(){
        step("Открыть страницу gitHub",()->
                open("https://github.com/selenide/selenide"));

        step("Перейти на вкладку ISSUE",()-> $(By.id("issues-tab")).click());

        step("Проверить наличие текста",()-> $(By.id("js-repo-pjax-container"))
                .shouldHave(Condition.text(ISSUE_TEXT)));

    }
}
