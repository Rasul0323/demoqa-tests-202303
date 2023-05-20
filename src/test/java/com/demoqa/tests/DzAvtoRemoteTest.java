package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DzAvtoRemoteTest extends RemoteTestBase {
    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulSearchTest() {
        step("Open form", () -> {
                    open("/automation-practice-form");
                    executeJavaScript("$('footer').remove()");
                    executeJavaScript("$('#fixedban').remove()");
                });
        step("Fill form", () -> {
        $("#firstName").setValue("Mr Tom");
        $("#lastName").setValue("Harison");
        $("#userEmail").setValue("vv@aaa.com");
        $(byText("Male")).click();
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
        });
        step("Verify results", () -> {
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
        });
    }
}