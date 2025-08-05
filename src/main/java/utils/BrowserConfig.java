package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserConfig {

    public static void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://qa-automation-practice.netlify.app";

        Selenide.open("/");

        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    public static void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
