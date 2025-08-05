package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ButtonsPage;
import pages.MainPage;
import utils.BrowserConfig;

import java.util.stream.IntStream;

public class ButtonsAndRadioBTest {

    MainPage mainPage = new MainPage();
    ButtonsPage buttonsPage = new ButtonsPage();

    @BeforeEach
    public void setUp() {
        BrowserConfig.setupBrowser();
        mainPage.expandButtonsPanel();
    }

    @Test
    public void t01CheckBoxTest() {
        mainPage.selectCheckBox();
        buttonsPage
                .clickOnCheckOrRadioByIndex(2)
                .verifyChecked(2, true)

                .clickOnCheckOrRadioByIndex(0)
                .verifyChecked(0, true)

                .clickOnCheckOrRadioByIndex(2)
                .verifyChecked(2, false);

        IntStream.rangeClosed(0, 2)
                .forEach(buttonsPage::clickOnCheckOrRadioByIndex);

        buttonsPage.clickOnResetButton();

        IntStream.rangeClosed(0, 2).forEach(i ->
                buttonsPage.verifyChecked(i, false)
        );
    }

    @Test
    public void t02CheckRadioButtonsTest() {
        mainPage.selectRadioButtons();
        buttonsPage
                .clickOnCheckOrRadioByIndex(0)
                .verifyOnlyRadioSelected(0)
                .clickOnCheckOrRadioByIndex(1)
                .verifyOnlyRadioSelected(1)
                .clickOnCheckOrRadioByIndex(2)
                .verifyOnlyRadioSelected(2)

                .verifySameTermsCheckIsDisabled(3);
    }

    @AfterEach
    void closeDriver() {
        BrowserConfig.closeBrowser();
    }
}
