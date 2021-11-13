package ru.umar.allureTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.umar.pages.GitHubPage;

import static com.codeborne.selenide.Selenide.open;

public class PageObjectTests {

    private GitHubPage gitHubPage = new GitHubPage();
    private final String ISSUE_TEXT = "Bad browser language in version 6+";

    @BeforeAll
    public static void openGit(){
        open("https://github.com/selenide/selenide");
    }

    @Test
    public void checkInscription(){
        gitHubPage.openIssuePage();
        gitHubPage.checkInscriptionOnPage(ISSUE_TEXT);
    }
}
