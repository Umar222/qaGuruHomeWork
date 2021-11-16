package ru.umar;


import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class javaFileTest {

    @DisplayName("Проверка ценника в прайслисте")
    @Test
    void checkFirstPageLine() throws IOException {
        open("https://recon-stroi.ru/index.php/prajs-list");
        File priceList = $("a[href=\"/images/smeta/welding_work.pdf\"]").download();
        PDF parsePDF = new PDF(priceList);
        assertTrue(parsePDF.text.contains("Монтаж металлоконструкций т. от 15 000"));
    }

    @DisplayName("Проверка отображени заголовка в прайслисте")
    @Test
    void checkTyrePrice() throws IOException {
        open("http://ctyre.ru/price-list/");
        File file = $("a[href=\"/price_ctyre.xls\"]").download();
        XLS parseXLSFile = new XLS(file);
        String price = parseXLSFile.excel
                .getSheetAt(0)
                .getSheetName();
        assertTrue(price.contains("Грузовые шины в Москве"), "Текст не совпадает");
    }

    @DisplayName("Отображение кнопки Скачать после загрузки файла")
    @Test
    void uploadPicture(){
        open("https://face.bubble.ru/ru/face");
        $(By.id("dropzone")).uploadFromClasspath("picture1.jpg");
        $("span[class=\"download-link__text\"]").shouldHave(Condition.visible);
    }


}
