package com.example.wikipedia;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseWikiTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = WikiDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void beforeEachBase() {
        open();
    }

    @AfterEach
    public void afterEachBase() {
        step("Close driver", Selenide::closeWebDriver);
    }
}
