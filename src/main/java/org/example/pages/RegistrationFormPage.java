package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormPage extends BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='icon icon__person']")
    private WebElement signInFormButton;
    @FindBy(xpath = "//button[@value='REGISTER']")
    private WebElement registerFormButton;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//input[@placeholder='+375 (__) ___-__-__']")
    private WebElement mobileForRegisterField;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//span[contains(@class, 'checkbox-visual')]")
    private WebElement checkboxForRegister;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//button[@name='SET_REGISTER']")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//p[contains(text(), 'уже заре')]")
    WebElement errorAlreadyText;

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }
    public WebElement getSignInFormButton() {
        return signInFormButton;
    }
    public WebElement getRegFormButton() {
        return registerFormButton;
    }
    public WebElement getRegMobileNumber() {
        return mobileForRegisterField;
    }
    public WebElement getRegisterCheckbox() {
        return checkboxForRegister;
    }
    public WebElement getRegisterButton() {
        return registerButton;
    }
    public WebElement getErrorAlreadyText() {
        return errorAlreadyText;
    }
}