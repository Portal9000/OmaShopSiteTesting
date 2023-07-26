package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationFormPage extends BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='icon icon__person']")
    private WebElement signInFormButton;
    @FindBy(xpath = "//input[@placeholder='+375 (__) ___-__-__']")
    private WebElement mobileForLoginField;
    @FindBy(xpath = "//input[@name='PASSWORD']")
    private WebElement passwordForLoginField;
    @FindBy(xpath = "//span[@class=\"checkbox-visual_icon icon icon__check\"]")
    private WebElement checkboxForLogin;
    @FindBy(xpath = "//button[@name=\"SET_LOGIN\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//p[contains(text(), 'Неверный')]")
    WebElement errorWrongPasswordText;
    @FindBy(xpath = "//h2[@class=\"personal-user_name\"]")
    WebElement accountOwnerName;

    public AuthorizationFormPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getSignInFormButton() {
        return signInFormButton;
    }
    public WebElement getLoginMobileNumber() {
        return mobileForLoginField;
    }
    public WebElement getLoginPassword() {
        return passwordForLoginField;
    }
    public WebElement getLoginCheckbox() {
        return checkboxForLogin;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
    public WebElement getErrorWrongPasswordText() {
        return errorWrongPasswordText;
    }
    public WebElement getAccountOwnerName() {
        return accountOwnerName;
    }
}