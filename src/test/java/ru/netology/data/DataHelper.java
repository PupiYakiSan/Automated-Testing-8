package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private static final Faker faker = new Faker(new Locale("en"));

    private DataHelper() {}

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfoTest() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static String generateRandomLogin() {
        return faker.name().username();
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode generateRandomCode() {
        return new VerificationCode(faker.numerify("######"));
    }

}
