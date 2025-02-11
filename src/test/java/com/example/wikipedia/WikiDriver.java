package com.example.wikipedia;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.URL;

public class WikiDriver implements WebDriverProvider {
    private static final String appiumUrl = "http://0.0.0.0:4723/";
    private static final String pathToApk = "src/test/resources/app/wiki.apk";

    @Override
    @SneakyThrows
    public WebDriver createDriver(Capabilities capabilities) {
        File apk = new File(pathToApk);

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setDeviceName("Pixel 2 API 30"); //из Девайсов
        options.setPlatformVersion("11.0");
        options.setApp(apk.getAbsolutePath());
        options.setAppPackage("org.wikipedia");
        options.setAppActivity(".main.MainActivity");
        options.autoGrantPermissions();
        options.setLanguage("ru");
        options.setLocale("RU");

        return new AndroidDriver(new URL(appiumUrl), options);
    }
}
