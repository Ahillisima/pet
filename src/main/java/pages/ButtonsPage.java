package pages;

import io.qameta.allure.Step;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ButtonsPage {

    public static final String TERMS_CHECK_SELECTOR = ".form-check-input";
    public static final String RESET_BUTTON_SELECTOR = ".btn-primary";

    @Step("Клик по чекбоксу/радиокнопке с индексом {index}")
    public ButtonsPage clickOnCheckOrRadioByIndex(int index) {
        $$(TERMS_CHECK_SELECTOR)
                .get(index)
                .click();
        return this;
    }

    @Step("Проверить, что 4 кнопка заблокирована")
    public ButtonsPage verifySameTermsCheckIsDisabled(int index) {
        $$(TERMS_CHECK_SELECTOR).get(index).shouldBe(disabled);
        return this;
    }

    @Step("Проверить, что чекбокс/радиокнопка с индексом {index} {(expected ? 'выбрана' : 'не выбрана')}")
    public ButtonsPage verifyChecked(int index, boolean expected) {
        $$(TERMS_CHECK_SELECTOR).get(index).shouldBe(expected ? checked : not(checked));
        return this;
    }

    @Step("Проверить, что выбрана только радиокнопка с индексом {expectedIndex}")
    public ButtonsPage verifyOnlyRadioSelected(int expectedIndex) {
        IntStream.range(0, $$(TERMS_CHECK_SELECTOR).size())
                .forEach(i -> verifyChecked(i, i == expectedIndex));
        return this;
    }

    @Step("Нажать кнопку сброса")
    public ButtonsPage clickOnResetButton() {
        $(RESET_BUTTON_SELECTOR).shouldBe(visible).click();
        return this;
    }
}
