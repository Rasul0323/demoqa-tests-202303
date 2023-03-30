package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Dzavtotest extends TestBase {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen=true;
    open ("/automation-practice-form");
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
        $("#uploadPicture").uploadFile(new File("src/test/resources/images/4.jpg"));
    }
}
