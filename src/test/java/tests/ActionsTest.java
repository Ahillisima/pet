package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ActionsPage;
import pages.MainPage;
import utils.BrowserConfig;

public class ActionsTest {

    MainPage mainPage = new MainPage();
    ActionsPage actionsPage = new ActionsPage();

    @BeforeEach
    public void setUp() {
        BrowserConfig.setupBrowser();
        mainPage.expandActionsPanel();
    }

    @Test
    public void t01CheckDoubleClickButton() {
        mainPage.selectDoubleClickPage();
        actionsPage
                .doubleClickOnButton()
                .verifyMessageAfterDoubleCickOnButton();
    }

    @Test
    public void t02ScrollTo() {
        mainPage.selectScrollingPage();
        actionsPage
                .scrollAndVerifyTextVisibility();
    }

    @Test
    public void t03CheckHover() {
        mainPage.selectHoverPage();
        actionsPage
                .verifyTextChangeOnHover()
                .verifyTextAfterHoverOnButton();
    }

    @Test
    public void t04CheckTextAfterClickOnButton() {
        mainPage.selectShowOrHidePage();
        actionsPage
                .verifyExistText(true)
                .clickOnShowOrHiddenButton()
                .verifyExistText(false)
                .clickOnShowOrHiddenButton()
                .verifyExistText(true);
    }

    @AfterEach
    void closeDriver() {
        BrowserConfig.closeBrowser();
    }
}
