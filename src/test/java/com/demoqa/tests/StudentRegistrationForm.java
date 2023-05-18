package com.demoqa.tests;

import com.github.javafaker.Faker;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;


public class StudentRegistrationForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(TestData.gender),
            userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 25)),
            monthOfBirth = faker.options().option(months),
            yearOfBirth = String.valueOf(getRandomInt(1956, 2004)),
            subject = faker.options().option(subjects),
            hobbies = faker.options().option(hobbiess),
            currentAddress = faker.address().streetAddress(),
            randomState = faker.options().option(states),
            randomCity = getRandomCity(randomState);

    @Tag("remote")
    @Test
    @DisplayName("Проверка тестовой формы")
    void practiceFormTest() {

        step("Открываем страницу", () -> {
            registrationPage.openPage();
        });
        step("Закрываем банер и футер", () -> {
            registrationPage.removeBanners();
        });
        step("Вводим имя и фамилию", () -> {
            registrationPage.setFirstName(firstName);
            registrationPage.setLastName(lastName);
        });
        step("Вводим email", () -> {
            registrationPage.setUserEmail(userEmail);
        });
        step("Выбираем гендер", () -> {
            registrationPage.setGender(userGender);
        });
        step("Вводим номер телефона", () -> {
            registrationPage.setNumber(userNumber);
        });
        step("Вводим дату рождения", () -> {
            registrationPage.setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth);
        });
        step("Выбираем предметы", () -> {
            registrationPage.setSubjects(subject);
        });
        step("Выбираем хобби", () -> {
            registrationPage.setHobby(hobbies);
        });
        step("Загружаем картинку", () -> {
            registrationPage.uploadPicture("duck.jpg");
        });
        step("Вводим адрес", () -> {
            registrationPage.setCurrentAddress(currentAddress);
        });
        step("Выбираем штат", () -> {
            registrationPage.setState(randomState);
        });
        step("Выбираем город", () -> {
            registrationPage.setCity(randomCity);
        });
        step("Кликаем на кнопку Submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверяем результат", () -> {
            registrationPage.verifyRegistrationResultsModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", userGender)
                    .verifyResult("Mobile", userNumber)
                    .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", "duck.jpg")
                    .verifyResult("Address", currentAddress)
                    .verifyResult("State and City", randomState + " " + randomCity);
        });
    }
}
