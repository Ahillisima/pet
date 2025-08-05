package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.TabOrWindowPage;
import utils.BrowserConfig;

public class TabOrWindowsTest {

    MainPage mainPage = new MainPage();
    TabOrWindowPage tabOrWindowPage = new TabOrWindowPage();

    @BeforeEach
    public void setUp() {
        BrowserConfig.setupBrowser();
        mainPage.expandNewTabOrWindowPanel();
    }

    @Test
    public void t01CheckOpenNewTab() {
        mainPage.selectBrowserTab();
        tabOrWindowPage
                .openNewTabPage()
                .switchToTabAndVerifyTable();
    }

    @Test
    public void t02CheckOpenNewWindow() {
        mainPage.selectWindowTab();
        tabOrWindowPage
                .openNewWindowPage()
                .switchToTabAndVerifyTable();
    }

    @AfterEach
    void closeDriver() {
        BrowserConfig.closeBrowser();
    }
}
