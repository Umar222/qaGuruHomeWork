package ru.umar.gitHubTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubUiTests {

    private static final String URL = "https://github.com/selenide/selenide";
    private final SelenideElement wikiTab = $("#wiki-tab");
    private final SelenideElement wikiBody = $(byText("Welcome to the selenide wiki!"));
    private final SelenideElement searchSoftAssertions = $(byText("Soft assertions"));
    private final SelenideElement assertionText = $("ol li");

    @Test
    void checkSoftAssertionsChapter(){
        open(URL);
        wikiTab.click();
        wikiBody.shouldBe(Condition.visible, Duration.ofSeconds(10));
        searchSoftAssertions.click();
        assertionText.parent().shouldHave(Condition.text("com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}
