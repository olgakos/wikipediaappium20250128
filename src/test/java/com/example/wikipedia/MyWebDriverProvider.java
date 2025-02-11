package com.example.wikipedia;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver() {
        // Настройка и создание экземпляра WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
