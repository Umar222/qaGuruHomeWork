package ru.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StudentRegistrationFormPage {


    private final SelenideElement firstNameField = $(By.id("firstName"));
    private final SelenideElement lastNameField = $(By.id("lastName"));
    private final SelenideElement emailField = $(By.id("userEmail"));
    private final SelenideElement userPhoneNumberField = $(By.id("userNumber"));
    private final SelenideElement currentAddress = $(By.id("currentAddress"));
    private final SelenideElement submitButton = $(By.id("submit"));
    private final SelenideElement uploadFileField = $(By.className("form-control-file"));
    public static final ElementsCollection dataBoard = $$(By.cssSelector(".table-responsive tdbody tr")).snapshot();



    public SelenideElement someButton = $(By.className("subjects-auto-complete__value-container"));

    public StudentRegistrationFormPage addCurrentAddress(String address){
        currentAddress.setValue(address);
        return this;
    }

    public StudentRegistrationFormPage chooseGender(String genderType) {
        $(By.xpath("//label[text() = \"" + genderType + "\"]")).click();
        return this;
    }

    public StudentRegistrationFormPage hobbiesCheckbox(String hobbiesType) {
        $(By.xpath("//label[contains(.,'" + hobbiesType + "')]")).click();
        return this;
    }

    public StudentRegistrationFormPage chooseStateField(String city) {
        $(By.id("state")).scrollTo().click();
        $(By.xpath("//div[@class = \" css-11unzgr\"]/div[text() = \"" + city + "\"]")).click();
        return this;
    }

    public StudentRegistrationFormPage chooseCityField(String state) {
        $(By.id("city")).click();
        $(By.xpath("//div[@id=\"city\"]//div[text() = \"" + state + "\"]")).click();
        return this;
    }

    public StudentRegistrationFormPage setFio(String firstName, String lastName) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        return this;
    }

    public StudentRegistrationFormPage emailField(String email) {
        emailField.setValue(email);
        return this;
    }

    public StudentRegistrationFormPage userPhoneNumberField(String userNumber) {
        userPhoneNumberField.setValue(userNumber);
        return this;
    }

    public StudentRegistrationFormPage addDateOfBirth(String day, String month, String year) {
        $(By.id("dateOfBirthInput")).click();
        $(By.cssSelector(".react-datepicker__month-select")).click();
        $(By.cssSelector(".react-datepicker__month-select")).selectOptionContainingText(month);
        $(By.cssSelector(".react-datepicker__year-select")).click();
        $(By.cssSelector(".react-datepicker__year-select")).selectOptionByValue(year);
        $(By.cssSelector(".react-datepicker__day--0"+day)).click();
        return this;
    }

    public StudentRegistrationFormPage subjectsContainerField(String subjectsContainer) {
        someButton.click();
        $(By.id("subjectsInput")).setValue(subjectsContainer);
        $(By.id("subjectsInput")).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String fileName) {
        uploadFileField.uploadFile(new File("src/test/resources/testFiles/"+fileName));
        uploadFileField.uploadFromClasspath("testFiles/"+fileName);
        return this;
    }

    public StudentRegistrationFormPage submit() {
        submitButton.click();
        return this;
    }


}
