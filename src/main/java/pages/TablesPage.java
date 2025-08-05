package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.DefaultTableData;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TablesPage {

    public static final String PEOPLE_TABLE_HEADERS_SELECTOR = "#peopleTable thead th";
    public static final String PEOPLE_TABLE_ROW_SELECTOR = "#peopleTable tbody tr";
    public static final String PEOPLE_TABLE_CELL_SELECTOR = "td,th";

    @Step("Проверить, что заголовки таблицы равны: {expectedHeaders}")
    public TablesPage verifyTableHeaders(List<String> expectedHeaders) {
        List<String> actualHeaders = $$(PEOPLE_TABLE_HEADERS_SELECTOR)
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());

        assertEquals(expectedHeaders, actualHeaders, "Заголовки таблицы не совпадают");
        return this;
    }

    @Step("Проверить, что таблица содержит строку: {expectedRow}")
    public TablesPage verifyTableContainsRow(List<String> expectedRow) {
        List<List<String>> allRows = getTableRowsText();
        assertTrue(allRows.contains(expectedRow),
                "Ожидаемая строка не найдена: " + expectedRow);
        return this;
    }

    @Step("Получить все строки таблицы в виде текста")
    public List<List<String>> getTableRowsText() {
        return $$(PEOPLE_TABLE_ROW_SELECTOR).stream()
                .map(row -> row.$$(PEOPLE_TABLE_CELL_SELECTOR).texts())
                .collect(Collectors.toList());
    }

    @Step("Проверить, что количество строк в таблице равно: {expectedCount}")
    public TablesPage verifyRowCount(int expectedCount) {
        int actualCount = $$(PEOPLE_TABLE_ROW_SELECTOR).size();
        assertEquals(expectedCount, actualCount, "Количество строк в таблице не совпадает");
        return this;
    }

    @Step("Проверить, что таблица полностью соответствует ожидаемой (по умолчанию)")
    public TablesPage verifyMatchesDefaultTable() {
        DefaultTableData expected = DefaultTableData.defaultPeopleTable();
        verifyTableHeaders(expected.getHeaders());
        expected.getRows().forEach(this::verifyTableContainsRow);
        verifyRowCount(expected.getRows().size());
        return this;
    }
}
