package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Numberdata;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ActionsPage {

    public static final String DOUBLE_CLICK_SELECTOR = "#double-click-btn";
    public static final String DOUBLE_CLICK_EVENT_SELECTOR = "#double-click-result";
    public static final String SECOND_BLOCK_SELECTOR = "#inject";
    public static final String THE_END_SELECTOR = "#the-end";
    public static final String HOVER_TEXT_SELECTOR = "#demo";
    public static final String HOVER_BUTTON_SELECTOR = "#button-hover-over";
    public static final String HIDDEN_BLOCK_SELECTOR = ".hide";
    public static final String SHOW_HIDE_BUTTON_SELECTOR = "#showHideBtn";
    public static final String HIDDEN_TEXT_SELECTOR = "#hiddenText";

    public static final String EXPECTED_SECOND_BLOCK_TEXT = "Lorem Ipsum";
    public static final String THE_END_TEXT = "THE END";
    public static final String HOVER_BEFORE = "If you hover this text, it will be changed.";
    public static final String HOVER_AFTER = "HOVERED";
    public static final String UNDER_HOVER_BUTTON_TEXT = "I am shown when someone hovers over the text above.";
    public static final String HIDDEN_TEXT = "This text will be hidden";

    @Step("Сделать двойнок клик по кнопке")
    public ActionsPage doubleClickOnButton() {
        $(DOUBLE_CLICK_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).doubleClick();
        return this;
    }

    @Step("Проверить сообщение после двойного клика")
    public void verifyMessageAfterDoubleCickOnButton() {
        $(DOUBLE_CLICK_EVENT_SELECTOR).shouldHave(exactText("Congrats, you double clicked!"));
    }

    @Step("Скролл до блока Lorem Ipsum и THE END, проверка видимости")
    public ActionsPage scrollAndVerifyTextVisibility() {
        SelenideElement secondBlock = $(SECOND_BLOCK_SELECTOR);
        executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'start'});", secondBlock);
        secondBlock.shouldBe(visible, Numberdata.waitingFor())
                .shouldHave(text(EXPECTED_SECOND_BLOCK_TEXT));

        SelenideElement theEnd = $(THE_END_SELECTOR);
        executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", theEnd);
        theEnd.shouldBe(visible, Numberdata.waitingFor())
                .shouldHave(exactText(THE_END_TEXT));
        return this;
    }

    @Step("Проверить поведение текста при наведении курсора")
    public ActionsPage verifyTextChangeOnHover() {
        SelenideElement hoverArea = $(HOVER_TEXT_SELECTOR).shouldBe(visible, Numberdata.waitingFor());
        hoverArea.shouldHave(exactText(HOVER_BEFORE));
        hoverArea.hover();
        hoverArea.shouldHave(exactText(HOVER_AFTER));
        return this;
    }

    @Step("Проверить появление текста при наведении курсора на кнопку")
    public ActionsPage verifyTextAfterHoverOnButton() {
        $(HOVER_BUTTON_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).hover();
        $(HIDDEN_BLOCK_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).shouldHave(exactText(UNDER_HOVER_BUTTON_TEXT));
        return this;
    }

    @Step("Нажать на кнопку для появления текста")
    public ActionsPage clickOnShowOrHiddenButton() {
        $(SHOW_HIDE_BUTTON_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Проверить наличие текста: ожидается {text}")
    public ActionsPage verifyExistText(boolean text) {
        SelenideElement element = $(HIDDEN_TEXT_SELECTOR)
                .shouldBe(text ? visible : not(visible), Numberdata.waitingFor())
                .shouldHave(text ? exactText(HIDDEN_TEXT) : not(exactText(HIDDEN_TEXT)));
        return this;
    }
}
