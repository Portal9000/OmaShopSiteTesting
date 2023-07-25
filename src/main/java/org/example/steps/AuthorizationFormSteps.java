package org.example.steps;

        import io.qameta.allure.Step;
        import lombok.extern.log4j.Log4j2;
        import org.example.models.UserData;
        import org.example.pages.AuthorizationFormPage;
        import org.example.utils.Waiters;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.testng.Assert;
        import org.testng.annotations.Test;

@Log4j2
public class AuthorizationFormSteps {

    private AuthorizationFormPage authorizationFormPage;

    public AuthorizationFormSteps(WebDriver driver) {
        authorizationFormPage = new AuthorizationFormPage(driver);
    }
    @Test(description = "Check wrong login form data")
    public void checkWrongLoginFormData() throws InterruptedException {
        Waiters.waitForVisibility(authorizationFormPage.getSignInFormButton());
        authorizationFormPage.getLoginMobileNumber("293305742");
        authorizationFormPage.getLoginPassword("aaa");
        authorizationFormPage.getLoginCheckbox().click();
        authorizationFormPage.getLoginButton().click();
        Thread.sleep(3000);
        Assert.assertTrue(authorizationFormPage.getErrorWrongText().contains("Неверный"));
    }
    @Test(description = "Check true login form data")
    public void checkTrueLoginFormData() throws InterruptedException {
        Waiters.waitForVisibility(authorizationFormPage.getSignInFormButton());
        authorizationFormPage.getLoginMobileNumber("293305742");
        authorizationFormPage.getLoginPassword("c114b9b2");
        authorizationFormPage.getLoginCheckbox().click();
        authorizationFormPage.getLoginButton().click();
        Thread.sleep(3000);
        Assert.assertTrue(authorizationFormPage.getaccountOwnerNameText().contains("Зинчук Александр Борисович"));
    }
    @Test(description = "Check wrong name form data")
    public void checkWrongNameFormData() throws InterruptedException {
        Waiters.waitForVisibility(authorizationFormPage.getSignInFormButton());
        authorizationFormPage.getLoginMobileNumber("293305742");
        authorizationFormPage.getLoginPassword("c114b9b2");
        authorizationFormPage.getLoginCheckbox().click();
        authorizationFormPage.getLoginButton().click();
        Thread.sleep(3000);
        Assert.assertTrue(authorizationFormPage.getaccountOwnerNameText().contains("Миша Джексон"));
    }
    }
}