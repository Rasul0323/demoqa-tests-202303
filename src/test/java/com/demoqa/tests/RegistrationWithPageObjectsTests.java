package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulSearchTest() {
        registrationPage.openPage()
                .setFirstName("Mr Tom")
                .setLastName("Harison")
                .setUserEmail("vv@aaa.com")
                .setGender("Male");
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("July")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1993")).click();
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("History");
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/4.jpg"));
        $("#currentAddress").setValue("Rp-27");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".table").shouldHave(
                text("Mr Tom Harison"),
                text("vv@aaa.com"),
                text("Male"),
                text("1111111111"),
                text("14 July,1993"),
                text("History"),
                text("Sports"),
                text("4.jpg"),
                text("Rp-27"),
                text("NCR Delhi"));
    }
}
