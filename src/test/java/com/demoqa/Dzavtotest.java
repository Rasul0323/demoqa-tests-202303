package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Dzavtotest {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen=true;
    open ("https://demoqa.com/avtomation-practice-form");
    }
}
