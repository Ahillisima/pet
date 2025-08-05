package pages;

import io.qameta.allure.Step;
import utils.Numberdata;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static final String FORMS_SELECTOR = "#forms";
    public static final String LOGIN_SELECTOR = "#login";
    public static final String REGISTER_SELECTOR = "#register";
    public static final String RECOVER_PASSWORD_SELECTOR = "#recover-password";
    public static final String BUTTONS_SELECTOR = "#buttons";
    public static final String CHECKBOX_SELECTOR = "#checkboxes";
    public static final String RADIO_BUTTONS_SELECTOR = "#radio-buttons";
    public static final String NEW_TAB_OR_WINDOW_SELECTOR = "a.dropdown-toggle[href='#browserSubmenu']";
    public static final String BROWSER_TAB_SELECTOR = "#browser-tab";
    public static final String BROWSER_WINDOW_SELECTOR = "#browser-window";
    public static final String ACTIONS_PAGE_SELECTOR = "#actions";
    public static final String DOUBLE_CLICK_PAGE_SELECTOR = "#double-click";
    public static final String SCROLLING_PAGE_SELECTOR = "#scrolling";
    public static final String HOVER_PAGE_SELECTOR = "#mouse-hover";
    public static final String SHOW_OR_HIDE_ELEMENT_PAGE_SELECTOR = "#show-hide-elements";
    public static final String DROPDOWN_PAGE_SELECTOR = "#dropdowns";

    @Step("Раскрыть панель 'Forms'")
    public MainPage expandFormsPanel() {
        $(FORMS_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Выбрать страницу 'Login'")
    public void selectLoginPage() {
        $(LOGIN_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать страницу 'Register'")
    public void selectRegisterPage() {
        $(REGISTER_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать страницу 'Recover Password'")
    public void selectRecoverPassword() {
        $(RECOVER_PASSWORD_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Раскрыть панель 'Buttons'")
    public MainPage expandButtonsPanel() {
        $(BUTTONS_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Выбрать 'Checkboxes'")
    public void selectCheckBox() {
        $(CHECKBOX_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать 'Radio Buttons'")
    public void selectRadioButtons() {
        $(RADIO_BUTTONS_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Раскрыть панель 'Browser Submenu'")
    public MainPage expandNewTabOrWindowPanel() {
        $(NEW_TAB_OR_WINDOW_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Выбрать 'Browser Tab'")
    public void selectBrowserTab() {
        $(BROWSER_TAB_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать 'New Browser Window'")
    public void selectWindowTab() {
        $(BROWSER_WINDOW_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Раскрыть панель 'Actions'")
    public MainPage expandActionsPanel() {
        $(ACTIONS_PAGE_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Выбрать 'Double Click'")
    public void selectDoubleClickPage() {
        $(DOUBLE_CLICK_PAGE_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать 'Scrolling'")
    public void selectScrollingPage() {
        $(SCROLLING_PAGE_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать 'Mouse Hover'")
    public void selectHoverPage() {
        $(HOVER_PAGE_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать 'Show or Hide Elements'")
    public void selectShowOrHidePage() {
        $(SHOW_OR_HIDE_ELEMENT_PAGE_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }

    @Step("Выбрать 'Dropdowns'")
    public void selectDropdownPage() {
        $(DROPDOWN_PAGE_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
    }
}