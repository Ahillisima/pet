package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import utils.Numberdata;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownPage {

    public static final String MULTI_LEVEL_DROPDOWN_SELECTOR = "#multi-level-dropdown-btn";
    public static final String MULTI_LEVEL_MENU_SELECTOR = "#multi-level-menu-ul";
    public static final String DROPDOWN_COUNTRY_SELECTOR = "#dropdown-menu";

    @Step("Открыть многоуровневое меню")
    public DropdownPage openMultiLevelDropdown() {
        $(MULTI_LEVEL_DROPDOWN_SELECTOR)
                .shouldBe(visible, Numberdata.waitingFor())
                .click();
        return this;
    }

    @Step("Проверить, что многоуровневое меню отображается")
    public DropdownPage verifyMultiLevelMenuIsVisible() {
        $(MULTI_LEVEL_MENU_SELECTOR)
                .shouldBe(visible, Numberdata.waitingFor());
        return this;
    }

    @Step("Клик по пункту меню '{menuItem.label}' и проверка URL")
    public DropdownPage clickMenuItemAndVerifyUrl(MenuItem menuItem) {
        hoverParents(menuItem);
        $(menuItem.getSelector())
                .shouldBe(visible, Numberdata.waitingFor())
                .click();
        assertTrue(Selenide.webdriver().driver().url().contains(menuItem.getAnchor()),
                "Ожидалось, что URL будет содержать: " + menuItem.getAnchor());
        return this;
    }

    @Step("Навести курсор на пункт меню: {item.label}")
    public DropdownPage hoverOverMenuItem(MenuItem item) {
        SelenideElement element = $(item.getSelector())
                .shouldBe(visible, Numberdata.waitingFor());

        element.hover();

        element.shouldBe(visible, Numberdata.waitingFor());

        return this;
    }

    @Step("Навести курсор по цепочке меню: {items}")
    public DropdownPage hoverPath(MenuItem... items) {
        for (MenuItem item : items) {
            hoverOverMenuItem(item);
        }
        return this;
    }

    private void hoverParents(MenuItem menuItem) {
        if (menuItem.getParent() != null) {
            hoverParents(menuItem.getParent()); // Рекурсивно наводим родителей
            $(menuItem.getParent().getSelector())
                    .shouldBe(visible, Numberdata.waitingFor())
                    .hover();
        }
    }

    @Getter
    @AllArgsConstructor
    public enum MenuItem {
        SOME_ACTION("Some action", "#some-action", null),
        SOME_OTHER_ACTION("Some other action", "#some-other-action", null),
        HOVER_ME("Hover me for more options", "#hover-me", null),

        SECOND_LEVEL_1("Second level - 1", "#second-level-1", HOVER_ME),
        SECOND_LEVEL_2("Second level - 2", "#second-level-2", HOVER_ME),
        SECOND_LEVEL_3("Second level - 3", "#second-level-3", HOVER_ME),
        EVEN_MORE("Even More..", "#even-more", HOVER_ME),

        THIRD_LEVEL_1("3rd level - 1", "#3rd-level-1", EVEN_MORE),
        THIRD_ANOTHER_LEVEL("another level", "#3rd-another-level", EVEN_MORE),

        FOURTH_LEVEL_1("4th level - 1", "#4th-level-1", THIRD_ANOTHER_LEVEL),
        FOURTH_LEVEL_2("4th level - 2", "#4th-level-2", THIRD_ANOTHER_LEVEL),
        FOURTH_LEVEL_3("4th level - 3", "#4th-level-3", THIRD_ANOTHER_LEVEL);

        private final String label;
        private final String anchor;
        private final MenuItem parent;

        public String getSelector() {
            return "a[href='" + anchor + "']";
        }
    }
}
