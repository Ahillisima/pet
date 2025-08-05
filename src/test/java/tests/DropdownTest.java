package tests;

import org.junit.jupiter.api.*;
import pages.DropdownPage;
import pages.FormsPage;
import pages.MainPage;
import testdata.Assets;
import utils.BrowserConfig;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static pages.DropdownPage.DROPDOWN_COUNTRY_SELECTOR;
import static pages.DropdownPage.MenuItem;

public class DropdownTest {

    MainPage mainPage = new MainPage();
    DropdownPage dropdownPage = new DropdownPage();

    @BeforeEach
    public void setUp() {
        BrowserConfig.setupBrowser();
        mainPage.selectDropdownPage();
    }

    @Test
    public void t02selectAndVerifyCountry() {
        new FormsPage()
                .chooseCountryBySelector(Assets.Country.RUSSIA.getLabel(), DROPDOWN_COUNTRY_SELECTOR);
    }

    private record MenuTestCase(List<MenuItem> hoverPath, MenuItem[] targets) {
    }

    private static Stream<MenuTestCase> menuTestCases() {
        return Stream.of(
                new MenuTestCase(List.of(),
                        new MenuItem[]{MenuItem.SOME_ACTION, MenuItem.SOME_OTHER_ACTION, MenuItem.HOVER_ME}),
                new MenuTestCase(List.of(MenuItem.HOVER_ME),
                        new MenuItem[]{MenuItem.SECOND_LEVEL_1, MenuItem.EVEN_MORE}),
                new MenuTestCase(List.of(MenuItem.HOVER_ME, MenuItem.EVEN_MORE),
                        new MenuItem[]{MenuItem.THIRD_LEVEL_1, MenuItem.THIRD_ANOTHER_LEVEL}),
                new MenuTestCase(List.of(MenuItem.HOVER_ME, MenuItem.EVEN_MORE, MenuItem.THIRD_ANOTHER_LEVEL),
                        new MenuItem[]{MenuItem.FOURTH_LEVEL_1, MenuItem.FOURTH_LEVEL_2, MenuItem.FOURTH_LEVEL_3})
        );
    }

    @TestFactory
    Stream<DynamicTest> navigateAllMenuLevels() {
        return menuTestCases()
                .flatMap(testCase ->
                        Stream.of(testCase.targets).map(target ->
                                dynamicTest(
                                        "Click " + target + " after hover " + testCase.hoverPath(),
                                        () -> {
                                            dropdownPage.openMultiLevelDropdown();
                                            if (!testCase.hoverPath().isEmpty()) {
                                                dropdownPage.hoverPath(
                                                        testCase.hoverPath().toArray(new MenuItem[0])
                                                );
                                            }
                                            dropdownPage.clickMenuItemAndVerifyUrl(target);
                                        }
                                )
                        )
                );
    }

    @AfterEach
    void closeDriver() {
        BrowserConfig.closeBrowser();
    }
}
