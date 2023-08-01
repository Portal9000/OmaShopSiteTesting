package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductFormPage extends BasePage {

    protected WebDriver driver;
    @FindBy(xpath = "//a[@href=\"/interer-i-otdelka-c\"]")
    private WebElement globalItemCategory;
    @FindBy(xpath = "//div[@data-items-visible='11']/a[@href=\"/laminat-c\"]")
    private WebElement itemCategory;
    @FindBy(xpath = "//div[@id=\"data-ga__catalog-products-grid\"]/div[1]")
    private WebElement item;
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

    public ProductFormPage(WebDriver driver) {
        super(driver);
    }
    public WebElement chooseGlobalItemCategory() { return globalItemCategory; }
    public WebElement chooseItemCategory() { return itemCategory; }
    public WebElement chooseItem() { return item; }
    public WebElement getBuyButton() { return buyButton; }
    public WebElement getOrderCartButton() { return orderCartButton; }
    public WebElement getNameItemInShop() { return nameItemInShop; }
    public WebElement getNameItemInCart() { return nameItemInCart; }
    public WebElement clickShut() { return shut; }
}
