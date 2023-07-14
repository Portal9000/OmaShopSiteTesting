package org.example.steps;

        import io.qameta.allure.Step;
        import lombok.extern.log4j.Log4j2;
        import org.example.models.UserData;
        import org.example.pages.RegistrationFormPage;
        import org.example.utils.Waiters;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;

@Log4j2
public class AuthorizationFormSteps {

    private AuthorizationFormPage authorizationFormPage;

    public AuthorizationFormSteps(WebDriver driver) {
        authorizationFormPage = new authorizationFormPage(driver);
    }
    @Step("Enter first name")
    public void enterFirstName(String firstName) {
        Waiters.waitForVisibility(authorizationFormPage.getFirstNameField());
        log.info("Enter first name");
        authorizationFormPage.getFirstNameField().sendKeys(firstName);
    }
    @Step("Enter last name")
    public void enterLastName(String lastName) {
        log.info("Enter last name");
        authorizationFormPage.getLastNameField().sendKeys(lastName);
    }
    @Step("Click male radio button")
    public void clickMaleRadioButton() {
        log.info("Click male radio button");
        authorizationFormPage.getMaleRadioButton().click();
    }
    @Step("Enter mobile number")
    public void enterMobileNumber(String mobileNumber) {
        log.info("Enter mobile number");
        authorizationFormPage.getMobileNumberField().sendKeys(mobileNumber);
    }
    @Step("Click submit button")
    public void clickSubmitButton() {
        log.info("Click submit button");
        authorizationFormPage.getSubmitButton().sendKeys(Keys.RETURN);  // click();
    }
    @Step("Get user data text")
    public String getUserDataText() {
        log.info("Get user data text");
        return authorizationFormPage.getUserDataText().getText();
    }

    @Step("Fill user form")
    public void fillForm(UserData userData) {
        Waiters.waitForVisibility(authorizationFormPage.getFirstNameField());
        log.info("Enter first name");
        authorizationFormPage.getFirstNameField().sendKeys(userData.getFirstName());
        log.info("Enter last name");
        authorizationFormPage.getLastNameField().sendKeys(userData.getLastName());
        log.info("Click male radio button");
        authorizationFormPage.getMaleRadioButton().click();
        log.info("Enter mobile number");
        authorizationFormPage.getMobileNumberField().sendKeys(userData.getMobileNumber());
        log.info("Click submit button");
        authorizationFormPage.getSubmitButton().sendKeys(Keys.RETURN);   //click();
    }
}