package ru.umar;

import com.codeborne.selenide.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ParameterTests {

    @ParameterizedTest
    @ValueSource(strings = {"picture1.jpg", "page2.png", "Wall.JPEG"})
    void checkUploadingDifferentFileFormats(String file){
        open("https://face.bubble.ru/ru/face");
        $(By.id("dropzone")).uploadFromClasspath(file);
        $("span[class=\"download-link__text\"]").shouldHave(Condition.visible);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ЮАР", "Россия", "Таджикистан"})
    void checkCountryDisplaying(String country){
        Configuration.timeout = 6000;
        open("https://samokatus.ru/");
        $("sk-client-input-base[icon=\"plane-to\"]").click();
        $("input[type = \"text\"]").setValue(country);
        $("perfect-scrollbar").shouldHave(Condition.text(country));
    }
}
