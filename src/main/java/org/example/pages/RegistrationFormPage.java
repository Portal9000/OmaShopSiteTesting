package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFormPage {

    @FindBy(xpath = "//a[@href=\"/interer-i-otdelka-c\"]")
    private WebElement chooseGlobalItemCategory;
    @FindBy(xpath = "//div[@data-items-visible='11']/a[@href=\"/laminat-c\"]")
    private WebElement chooseItemCategory;
    @FindBy(xpath = "//div[@id=\"data-ga__catalog-products-grid\"]/div[1]")
    private WebElement chooseItem;
    @FindBy(xpath = "//div[contains(@class, 'showNotInOrder')]/div[@class='count-and-btn_btn']")
    private WebElement buyButton;
    @FindBy(xpath = "//a[@id=\"composite-order-btn-smalcart\"]")
    private WebElement orderCartButton;
    @FindBy(xpath = "//*[@id=\"comp_6a4963e7e6441c8ef5595107e18d5831\"]/section/section[1]/div[1]/h1")
    private WebElement nameItemInShop;
    @FindBy(xpath = "//a[@class=\"basket-product-item_title js-broadcast-hover\"]")
    private WebElement nameItemInCart;

    @FindBy(xpath = "//div[@class='backdrop-close']")
    private WebElement shut;

    public RegistrationFormPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
    }

    public void clickChooseGlobalItemCategoryButton() { chooseGlobalItemCategory.click(); }
    public void clickChooseItemCategoryButton() { chooseItemCategory.click(); }
    public void clickChooseItem() { chooseItem.click(); }
    public void clickBuyButton() { buyButton.click(); }
    public void clickOrderCartButton() { orderCartButton.click(); }
    public String getNameItemInShop() { return nameItemInShop.getText(); }
    public String getNameItemInCart() { return nameItemInCart.getText(); }

    public void clickShut() { shut.click(); }
}