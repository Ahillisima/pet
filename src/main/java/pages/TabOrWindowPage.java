package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import utils.Numberdata;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TabOrWindowPage {

    public static final String OPEN_NEW_TAB_BUTTON_SELECTOR = "#newTabBtn";
    public static final String OPEN_NEW_WINDOW_BUTTON_SELECTOR = "#newWindowBtn";

    @Step("Открыть новую вкладку")
    public TabOrWindowPage openNewTabPage() {
        $(OPEN_NEW_TAB_BUTTON_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Открыть новое окно")
    public TabOrWindowPage openNewWindowPage() {
        $(OPEN_NEW_WINDOW_BUTTON_SELECTOR).shouldBe(visible, Numberdata.waitingFor()).click();
        return this;
    }

    @Step("Переключение на новую вкладку, проверка таблицы и возврат в основное окно")
    public void switchToTabAndVerifyTable() {
        Selenide.switchTo().window(1);
        new TablesPage().verifyMatchesDefaultTable();
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
    }
}
