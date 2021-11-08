package ru.umar.gitHubTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import ru.pages.StudentRegistrationFormPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;


public class Lesson2 {

    public StudentRegistrationFormPage registrationFormElements;
    Faker faker = new Faker();


    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().cellPhone(),
            address = faker.address().streetAddress();

    @BeforeEach
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    Map<String, String> formValues = new HashMap<String, String>(){{
        put("Student Name", firstName);
        put("Student Email", lastName);
        put("Gender", "Male");
        put("Mobile", phoneNumber);
        put("Date of Birth", firstName);
        put("Subjects", "English");
        put("Hobbies", "Sports");
        put("Picture", "picture1.jpg");
        put("Address", firstName);
        put("State and City", "NCR");
    }};

    @Test
    public void formFilling() {
        new StudentRegistrationFormPage()
                .setFio(firstName, lastName)
                .emailField(email)
                .chooseGender("Male")
                .userPhoneNumberField(phoneNumber)
                .subjectsContainerField("English")
                .addDateOfBirth("01", "January", "1919")
                .hobbiesCheckbox("Sports")
                .uploadPicture("picture1.jpg")
                .addCurrentAddress(address)
                .chooseStateField("NCR")
                .chooseCityField("Delhi")
                .submit();


        for(SelenideElement values: StudentRegistrationFormPage.dataBoard){
            String key = values.$("td").text();
            String expectedValues = formValues.get(key);
            values.$("td", 1).shouldHave(Condition.text(expectedValues));
        }
    }


}
