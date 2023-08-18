package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }

    public DashboardPage validVerify(String verificationCode){
        verify(verificationCode);
        return new DashboardPage();
    }

    public  void verifyVerificationPageVisible () {
        codeField.shouldBe(Condition.visible);
    }

    public void verifyErrorNotificationVisible() {
        errorNotification.shouldBe(Condition.visible);
    }

}
