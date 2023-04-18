package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulSearchTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Mr Tom")
                .setLastName("Harison")
                .setUserEmail("vv@aaa.com")
                .setGender("Male")
                .setNumber("1111111111")
                .setBirthDate("14", "July", "1993")
                .setSubjects("History")
                .setHobby("Sports")
                .uploadPicture("4.jpg")
                .setCurrentAddress("Rp-27")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();
        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Mr Tom Harison")
                .verifyResult("Student Email", "vv@aaa.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1111111111")
                .verifyResult("Date of Birth", "14 July,1993")
                .verifyResult("Subjects", "History")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "4.jpg")
                .verifyResult("Address", "Rp-27")
                .verifyResult("State and City", "NCR Delhi");
    }
}
