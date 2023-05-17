package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class RemoteTestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = System.getProperty("remote");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserSize = System.getProperty("browserSize");
        String[] browser = System.getProperty("browser").split(":");
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];
        //Configuration.browser = "chrome";


    }
}
