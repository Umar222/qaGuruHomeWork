package ru.umar.gitHubTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @Test
    void checkDragAndDrop(){
        SelenideElement elementA = $(By.id("column-a"));
        SelenideElement elementB = $(By.id("column-b"));
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(elementA).dragAndDropTo(elementB);
        $(By.xpath("//div[@id = \"column-a\"]/header")).shouldHave(Condition.text("B"));
    }
}
