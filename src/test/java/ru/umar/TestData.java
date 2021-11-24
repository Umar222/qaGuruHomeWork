package ru.umar;


import com.github.javafaker.Faker;

public class TestData {

   static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().cellPhone(),
            address = faker.address().streetAddress();
}
