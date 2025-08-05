package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormsPage;
import pages.MainPage;
import testdata.Assets;
import utils.BrowserConfig;

import static pages.FormsPage.COUNTRY_SELECTOR;

public class FormsTests {

    MainPage mainPage = new MainPage();
    FormsPage formsPage = new FormsPage();

    @BeforeEach
    public void setUp() {
        BrowserConfig.setupBrowser();
        mainPage.expandFormsPanel();
    }

    @Test
    public void t01RegisterNewUser() {
        mainPage.selectRegisterPage();
        formsPage
                .setFirstName(Assets.randomFirstName())
                .setLastName(Assets.randomLastName())
                .setPhoneNumber(Assets.randomPhoneNumber())
                .chooseCountryBySelector(Assets.Country.GERMANY.getLabel(), COUNTRY_SELECTOR)
                .setEmailAddress(Assets.randomEmail())
                .setPassword(Assets.strongPassword())
                .clickOnCheckBox()
                .clickOnRegisterButton();
    }

    @Test
    public void t02LoginUser() {
        mainPage.selectLoginPage();
        formsPage
                .setEmail(Assets.randomEmail())
                .setPassword(Assets.strongPassword())
                .clickOnSubmitButton()
        ;
    }

    @Test
    public void t03RecoverPassword() {
        String email = Assets.randomEmail();
        mainPage.selectRecoverPassword();
        formsPage
                .setEmail(email)
                .clickOnRecoverPasswordButton()
                .verifyMessageSentEmail(email);
    }

    @Test
    public void t04RegisterAndLoginUser() {
        String email = Assets.randomEmail();
        String password = Assets.strongPassword();

        mainPage.selectRegisterPage();
        formsPage
                .setFirstName(Assets.randomFirstName())
                .setLastName(Assets.randomLastName())
                .setPhoneNumber(Assets.randomPhoneNumber())
                .chooseCountryBySelector(Assets.Country.GERMANY.getLabel(), COUNTRY_SELECTOR)
                .setEmailAddress(email)
                .setPassword(password)
                .clickOnCheckBox()
                .clickOnRegisterButton()
                .verifyMessageRegistration();

        mainPage.expandFormsPanel().selectLoginPage();
        formsPage
                .setEmail(email)
                .setPassword(password);
    }

    @AfterEach
    void closeDriver() {
        BrowserConfig.closeBrowser();
    }
}
