package testdata;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Assets {

    private static final Random RANDOM = new Random();

    @Step("Сгенерировать случайное имя")
    public static String randomFirstName() {
        return capitalize(RandomStringUtils.randomAlphabetic(5, 8).toLowerCase());
    }

    @Step("Сгенерировать случайную фамилию")
    public static String randomLastName() {
        return capitalize(RandomStringUtils.randomAlphabetic(5, 10).toLowerCase());
    }

    @Step("Сгенерировать случайный номер телефона")
    public static String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    @Step("Сгенерировать случайный email")
    public static String randomEmail() {
        return "user_" + RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@test.com";
    }

    @Step("Сгенерировать простой пароль")
    public static String simplePassword() {
        return RandomStringUtils.random(6, true, false).toLowerCase();
    }

    @Step("Сгенерировать сложный пароль")
    public static String strongPassword() {
        String upper = RandomStringUtils.random(3, 65, 90, true, true);       // ABC
        String lower = RandomStringUtils.random(3, 97, 122, true, true);      // abc
        String digits = RandomStringUtils.randomNumeric(2);                   // 12
        String special = RandomStringUtils.random(2, "!@#$%&*");              // $!

        String raw = upper + lower + digits + special;
        return shuffleString(raw);
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static String shuffleString(String input) {
        List<Character> characters = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(characters);
        StringBuilder sb = new StringBuilder();
        characters.forEach(sb::append);
        return sb.toString();
    }

    @Getter
    @AllArgsConstructor
    public enum Country {
        USA("United States"),
        RUSSIA("Russia"),
        JAPAN("Japan"),
        GERMANY("Germany"),
        FRANCE("France");

        private final String label;
    }
}
