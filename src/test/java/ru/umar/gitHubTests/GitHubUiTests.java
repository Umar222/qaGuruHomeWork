package ru.umar.gitHubTests;

import com.codeborne.selenide.SelenideElement;
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
        $(By.xpath("//button[@class=\"f6 Link--muted js-wiki-more-pages-link btn-link mx-auto\"]")).click();
        $(By.xpath("//div[@class=\"Box Box--condensed color-shadow-small\"]")).shouldHave(text("SoftAssertions"));
        $(By.xpath("//a[@href=\"/selenide/selenide/wiki/SoftAssertions\"]")).click();
        $(By.className("markdown-body")).shouldHave(text("Using JUnit5 extend test class:"));
    }

    @Test
    void dragAndDropTest(){
        SelenideElement elementA = $(By.id("column-a"));
        SelenideElement elementB = $(By.id("column-b"));
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(elementA).dragAndDropTo(elementB);
    }


}
