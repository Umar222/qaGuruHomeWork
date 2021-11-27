package ru.umar.gitHubTests;

import org.junit.jupiter.api.*;
import ru.umar.TestBase;
import ru.umar.pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.umar.TestData.*;


public class Lesson2 extends TestBase {

    StudentRegistrationFormPage registration = new StudentRegistrationFormPage();


    @Test
    @Tag("smoke")
    void formFilling() {
        open("https://demoqa.com/automation-practice-form");
        registration
                .setFio(firstName, lastName)
                .emailField(email)
                .chooseGender("Male")
                .userPhoneNumberField("9539323424")
                .subjectsContainerField("English")
                .addDateOfBirth("01", "January", "1919")
                .hobbiesCheckbox("Sports")
                .uploadPicture("picture1.jpg")
                .addCurrentAddress(address)
                .chooseStateField("NCR")
                .chooseCityField("Delhi")
                .submit();

        registration.checkTableTitle("Thanks for submitting the form");

        registration.checkResultsTableValue("Student Name", firstName +" "+ lastName)
                .checkResultsTableValue("Student Email", email)
                .checkResultsTableValue("Gender", "Male")
                .checkResultsTableValue("Mobile", "9539323424")
                .checkResultsTableValue("Date of Birth", "01 January,1919")
                .checkResultsTableValue("Subjects", "English")
                .checkResultsTableValue("Hobbies", "Sports")
                .checkResultsTableValue("Picture", "picture1.jpg")
                .checkResultsTableValue("Address", address)
                .checkResultsTableValue("State and City", "NCR Delhi");
    }

    @Test
    @Tag("smoke")
    void formFillingSpecialFiledTest() {
        open("https://demoqa.com/automation-practice-form");
        registration
                .setFio(firstName, lastName)
                .emailField(email)
                .chooseGender("Male")
                .userPhoneNumberField("9539323424")
                .subjectsContainerField("English")
                .addDateOfBirth("01", "January", "1919")
                .hobbiesCheckbox("Sports")
                .uploadPicture("picture1.jpg")
                .addCurrentAddress(address)
                .chooseStateField("NCR")
                .chooseCityField("Delhi")
                .submit();

        registration.checkTableTitle("Thanks for submitting the form");

        registration.checkResultsTableValue("Student Name", firstName +" "+ lastName)
                .checkResultsTableValue("Student Email", email)
                .checkResultsTableValue("Gender", "Male")
                .checkResultsTableValue("Mobile", "9539323424")
                .checkResultsTableValue("Date of Birth", "01 January,1929")
                .checkResultsTableValue("Subjects", "English")
                .checkResultsTableValue("Hobbies", "Sports")
                .checkResultsTableValue("Picture", "picture1.jpg")
                .checkResultsTableValue("Address", address)
                .checkResultsTableValue("State and City", "NCR Delhi");
    }


}
