package com.example.wikipedia;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

public class WikiTest extends BaseWikiTest {
    @Test
    void someTest() {
        $x("//*[contains(@resource-id,'skip_button')]").click();
        $(AppiumBy.accessibilityId("Поиск по Википедии")).click();
        $x("//*[contains(@resource-id,'search_src_text')]").setValue("Warhammer");

        $x("//*[contains(@text,\"Ересь Хоруса\")]").scrollTo().should(appear);
    }

}
