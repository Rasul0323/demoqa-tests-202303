package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    //SelenideElements/locator/etc
    SelenideElement FormHeaderText=$(".practice-form-wrapper"),
     firstNameInput=$("#firstName"),
     lastNameInput=$("#lastName"),
     userEmailInput=$("#userEmail"),
     gender=$("#genterWrapper");
    //Actions

    public RegistrationPage openPage() {
        open ("/automation-practice-form");
        FormHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //$("#firstName").setValue("Mr Tom");
        return this;
    }    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }


    public RegistrationPage setLastName(String value) {
            lastNameInput.setValue(value);
        return this;


    }


    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;

    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;

    }
}
