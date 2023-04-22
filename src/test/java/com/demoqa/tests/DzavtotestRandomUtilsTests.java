package com.demoqa.tests;

import com.github.javafaker.Faker;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;


public class DzavtotestRandomUtilsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    void practiceFormTest() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(TestData.gender),
                userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
                dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 25)),
                monthOfBirth = getRandomItemFromArray(months),
                yearOfBirth = String.valueOf(getRandomInt(1956,2004)),
                subject = getRandomItemFromArray(subjects),
                hobbies = getRandomItemFromArray(hobbiess),
                currentAddress = faker.address().streetAddress(),
                randomState = getRandomItemFromArray(states),
                randomCity = getRandomCity(randomState);

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobby(hobbies)
                .uploadPicture("4.jpg")
                .setCurrentAddress(currentAddress)
                .setState(randomState)
                .setCity(randomCity)
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "4.jpg")
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", randomState + " " + randomCity);
    }
}
