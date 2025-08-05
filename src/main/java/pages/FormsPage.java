package pages;

import io.qameta.allure.Step;
import utils.Numberdata;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class FormsPage {

    public static final String EMAIL_SELECTOR = "#email";
    public static final String PASSWORD_SELECTOR = "#password";
    public static final String SUBMIT_LOGIN_SELECTOR = "#submitLoginBtn";

    public static final String FIRST_NAME_SELECTOR = "#firstName";
    public static final String LAST_NAME_SELECTOR = "#lastName";
    public static final String PHONE_NUMBER_SELECTOR = "#phone";
    public static final String COUNTRY_SELECTOR = "#countries_dropdown_menu";
    public static final String EMAIL_ADDRESS_SELECTOR = "#emailAddress";
    public static final String REGISTER_BUTTON_SELECTOR = "#registerBtn";
    public static final String CHECK_BOX_SELECTOR = "#exampleCheck1";
    public static final String RECOVER_PASSWORD_BUTTON = "button.btn.btn-primary[onclick='recoverPassword()']";

    public static final String MESSAGE_SELECTOR = "#message";

    @Step("Ввести имя: {firstName}")
    public FormsPage setFirstName(String firstName) {
        $(FIRST_NAME_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).sendKeys(firstName);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public FormsPage setLastName(String lastName) {
        $(LAST_NAME_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).sendKeys(lastName);
        return this;
    }

    @Step("Ввести номер телефона: {number}")
    public  FormsPage setPhoneNumber (String number) {
        $(PHONE_NUMBER_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).sendKeys(number);
        return this;
    }

    @Step("Выбрать страну по локатору: {selector}, страна: {country}")
    public FormsPage chooseCountryBySelector(String country, String selector) {
        $(selector).shouldBe(visible, Numberdata.waitingFor()).selectOption(country);
        $(selector).getSelectedOption().shouldHave(text(country));
        return this;
    }

    @Step("Ввести email на странице регистрации: {email}")
    public FormsPage setEmailAddress(String email) {
        $(EMAIL_ADDRESS_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).sendKeys(email);
        return this;
    }

    @Step("Ввести email на странице логина и восстановления пароля: {email}")
    public FormsPage setEmail(String email) {
        $(EMAIL_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).sendKeys(email);
        return this;
    }

    @Step("Ввести пароль: {password}")
    public FormsPage setPassword(String password) {
        $(PASSWORD_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку входа")
    public void clickOnSubmitButton() {
        $(SUBMIT_LOGIN_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    public FormsPage clickOnRecoverPasswordButton() {
        $(RECOVER_PASSWORD_BUTTON).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Поставить чекбокс")
    public FormsPage clickOnCheckBox() {
        $(CHECK_BOX_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Нажать на кнопку регистрации")
    public FormsPage clickOnRegisterButton() {
        $(REGISTER_BUTTON_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Проверка сообщения об отправке пароля на почту: {email}")
    public FormsPage verifyMessageSentEmail(String email) {
        String expectedText = "An email with the new password has been sent to " + email + ". Please verify your inbox!";
        $(MESSAGE_SELECTOR)
                .shouldBe(visible, Numberdata.waitingFor())
                .shouldHave(exactText(expectedText));
        return this;
    }

    @Step("Проверка, что пользователь успешно зарегестрирован")
    public void verifyMessageRegistration () {
        String expectedText = "The account has been successfully created!";
        $(MESSAGE_SELECTOR)
                .shouldBe(visible, Numberdata.waitingFor())
                .shouldHave(exactText(expectedText));
    }
}
