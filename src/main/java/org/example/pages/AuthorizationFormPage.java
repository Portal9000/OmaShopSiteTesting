package org.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationFormPage {

    @FindBy(xpath = "//input[@placeholder='+375 (__) ___-__-__']")
    private WebElement mobileForLoginField;
    @FindBy(xpath = "//input[@name='PASSWORD']")
    private WebElement passwordForLoginField;
    @FindBy(xpath = "//span[@class=\"checkbox-visual_icon icon icon__check\"]")
    private WebElement checkboxForLogin;
    @FindBy(xpath = "//button[@name=\"SET_LOGIN\"]")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//p[contains(text(), 'Неверный')]")
    WebElement errorWrongText;
    @FindBy(xpath = "//h2[@class=\"personal-user_name\"]")
    WebElement accountOwnerNameText;

    public AuthorizationFormPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }
    public void clickCommonRegFormButton() { commonRegisterFormButton.click(); }
    public void clickRegFormButton() {
        registerFormButton.sendKeys(Keys.RETURN);
    }
    public void enterRegMobileNumber(String mobileNumber) {
        mobileForRegisterField.sendKeys(mobileNumber);
    }
    public void setRegisterCheckbox() {
        checkboxForRegister.click();
    }
    public void clickRegisterButton() {
        registerButton.click();
    }
    public String getErrorAlreadyText() {
        return errorAlreadyText.getText();
    }

    public void enterLogMobileNumber(String mobileNumber) {
        mobileForLoginField.sendKeys(mobileNumber);
    }
    public void enterLogPassword(String password) {
        passwordForLoginField.sendKeys(password);
    }
    public void setLoginCheckbox() {
        checkboxForLogin.click();
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public String getErrorWrongText() {
        return errorWrongText.getText();
    }
    public String getaccountOwnerNameTextText() {
        return accountOwnerNameText.getText();
    }


}