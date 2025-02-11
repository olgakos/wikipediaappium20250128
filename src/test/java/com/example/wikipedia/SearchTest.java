package com.example.wikipedia;

        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.remote.MobileCapabilityType;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.DesiredCapabilities;

        import java.net.URL;
        import java.util.concurrent.TimeUnit;

public class SearchTest {

    private AndroidDriver<WebElement> driver;

    @BeforeEach
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "andr11"); // Имя устройства
        //D:\JavaParty\appDemoFolder\wiki.apk
        //D:/JavaParty/appDemoFolder/wiki.apk
        //"/path/to/your/wikipedia.apk"
        //src/test/resources/app/wiki.apk
        //D:\JavaParty\wikipediaapium20250128/src/test/resources
        capabilities.setCapability(MobileCapabilityType.APP, "src/test/resources/app/wiki.apk"); // Путь к .apk
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchFunctionality() {
        // Находим элемент поиска и вводим текст
        WebElement searchBox = driver.findElement(By.id("org.wiki:id/search_container"));
        searchBox.click();
        WebElement searchInput = driver.findElement(By.id("org.wiki:id/search_src_text"));
        searchInput.sendKeys("Appium");

        // Проверяем результаты поиска
        WebElement firstResult = driver.findElement(By.id("org.wiki:id/page_list_item_title"));
        assert firstResult.getText().contains("Appium");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

