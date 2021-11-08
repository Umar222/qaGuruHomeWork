package ru.umar.gitHubTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubUiTests {


    @Test
    void checkSoftAssertionsChapter(){
        open("https://github.com/selenide/selenide");
        $(By.id("wiki-tab")).click();
        $(By.id("wiki-body")).shouldHave(text("Welcome to the selenide wiki!"));
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(By.xpath("//a[@href=\"/selenide/selenide/wiki/SoftAssertions\"]")).click();
        $(By.className("markdown-body")).shouldHave(text("Using JUnit5 extend test class:"));
    }
}
