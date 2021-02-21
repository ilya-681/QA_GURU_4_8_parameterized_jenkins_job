package test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
//        Configuration.remote = System.getProperty("remote_driver");

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/";
    }
}
