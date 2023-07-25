package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.RegistrationFormPage;
import org.example.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class RegistrationFormSteps {

    private RegistrationFormPage registrationFormPage;

    public RegistrationFormSteps(WebDriver driver) {
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Step("Get user data text")
    public String getErrorAlreadyText() {
        log.info("Get user data text");
        return registrationFormPage.getErrorAlreadyText().getText();
    }

    @Step("Fill register form")
    public void fillRegisterForm() throws InterruptedException {                   //TODO Убрать эксепшн после удаления sleep
        Waiters.waitForVisibility(registrationFormPage.getSignInFormButton());
        log.info("Wait for visibility SignIn button");
        registrationFormPage.getSignInFormButton().click();
        log.info("Enter SignIn button");
        registrationFormPage.getRegFormButton().sendKeys(Keys.RETURN);            //TODO Click()
        log.info("Enter button for registration");
        Thread.sleep(3000);
        registrationFormPage.getRegMobileNumber().sendKeys("293305742");
        log.info("Enter already registered mobile number");
        registrationFormPage.getRegisterCheckbox().click();
        log.info("Set check-box for registration");
        registrationFormPage.getRegisterButton().click();
        log.info("Click Register button");
    }
}