package ru.netology.banklogin;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private static final Faker faker = new Faker(new Locale("en"));
    private DataHelper() {}
    public static AuthInfo getAuthInfoWhihTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    private static String generateRandomLogin() {
        return faker.name().username();
    }
    private static String generateRandomPassword() {
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(),generateRandomPassword());
    }
    public  static VerificationCode(faker.numerify("######"));
}
