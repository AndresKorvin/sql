package ru.netology.banklogin.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import ru.netology.banklogin.data.DataHelper;
import ru.netology.banklogin.data.SqlHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");
    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(Condition.exactText(expectedText)).shouldBe(Condition.visible);
    }
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void verifyBlockedUserStatus(DataHelper.AuthInfo authInfo) {
        var userStatusBlocked = "blocked";
        var userStatus = SqlHelper.getUserStatus(authInfo);
        Assertions.assertTrue(userStatus.equals(userStatusBlocked));
    }

    public void clearLoginAndPasswordFields(){
        loginField.sendKeys("\b\b\b\b\b\b");
        passwordField.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b");
    }
}
