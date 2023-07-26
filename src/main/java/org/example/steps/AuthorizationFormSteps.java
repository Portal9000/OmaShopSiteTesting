package org.example.steps;

        import io.qameta.allure.Step;
        import lombok.extern.log4j.Log4j2;
        import org.example.models.UserData;
        import org.example.pages.AuthorizationFormPage;
        import org.example.utils.Waiters;
        import org.openqa.selenium.WebDriver;
        import org.testng.annotations.Test;

@Log4j2
public class AuthorizationFormSteps {

    private AuthorizationFormPage authorizationFormPage;

    public AuthorizationFormSteps(WebDriver driver) {
        authorizationFormPage = new AuthorizationFormPage(driver);
    }
    @Test(description = "Check wrong login form data")
    public void checkWrongPassFormData() {
        Waiters.waitForVisibility(authorizationFormPage.getSignInFormButton());
        authorizationFormPage.getSignInFormButton().click();
        authorizationFormPage.getLoginMobileNumber().sendKeys("293305742");
        authorizationFormPage.getLoginPassword().sendKeys("aaa");
        authorizationFormPage.getLoginCheckbox().click();
        authorizationFormPage.getLoginButton().click();
    }
    @Test(description = "Check true login form data")
    public void checkTrueLoginFormData() {
        Waiters.waitForVisibility(authorizationFormPage.getSignInFormButton());
        authorizationFormPage.getSignInFormButton().click();
        authorizationFormPage.getLoginMobileNumber().sendKeys("293305742");
        authorizationFormPage.getLoginPassword().sendKeys("c114b9b2");
        authorizationFormPage.getLoginCheckbox().click();
        authorizationFormPage.getLoginButton().click();
    }
    @Test(description = "Check wrong name form data")
    public void checkWrongNameFormData() {
        Waiters.waitForVisibility(authorizationFormPage.getSignInFormButton());
        authorizationFormPage.getSignInFormButton().click();
        authorizationFormPage.getLoginMobileNumber().sendKeys("293305742");
        authorizationFormPage.getLoginPassword().sendKeys("c114b9b2");
        authorizationFormPage.getLoginCheckbox().click();
        authorizationFormPage.getLoginButton().click();
    }

    @Step("Get error password text")
    public String getErrorWrongPasswordText() {
        log.info("Get error password text");
        return authorizationFormPage.getErrorWrongPasswordText().getText();
    }

    @Step("Get account owner name")
    public String getAccountOwnerName() {
        log.info("Get account owner name");
        return authorizationFormPage.getAccountOwnerName().getText();
    }
}