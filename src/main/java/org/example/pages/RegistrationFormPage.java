package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFormPage {

    @FindBy(xpath = "//span[@class='icon icon__person']")
    private WebElement commonRegisterFormButton;
    @FindBy(xpath = "//button[@value='REGISTER']")
    private WebElement registerFormButton;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//input[@placeholder='+375 (__) ___-__-__']")
    private WebElement mobileForRegisterField;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//span[contains(@class, 'checkbox-visual')]")
    private WebElement checkboxForRegister;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//button[@name='SET_REGISTER']")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@style=\"opacity: 1;\"]//p[contains(text(), 'уже зарегистрирован')]")
    WebElement errorAlreadyText;

    public RegistrationFormPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }
    public void clickCommonRegFormButton() {
        commonRegisterFormButton.click();
    }
    public void clickRegFormButton() {
        registerFormButton.click();
    }
    public void enterMobileNumber(String mobileNumber) {
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


//    public void enterFirstName(String firstName) {
//        firstNameField.sendKeys(firstName);
//    }
//
//    public void enterLastName(String lastName) {
//        lastNameField.sendKeys(lastName);
//    }
//
//    public void clickMaleRadioButton() {
//        maleRadioButton.click();
//    }
//
//
//    public void clickSubmitButton() {
//        submitButton.sendKeys(Keys.RETURN);
//    }
//

}