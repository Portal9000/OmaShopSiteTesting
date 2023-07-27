package org.example.steps;

import lombok.extern.log4j.Log4j2;
import org.example.pages.ProductFormPage;
import org.example.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Log4j2
public class SendingGoodsToCartSteps {

    private ProductFormPage productFormPage;
    public String nameItemInShop;
    public String nameItemInCart;

    public SendingGoodsToCartSteps(WebDriver driver) {
        productFormPage = new ProductFormPage(driver);
    }

    @Test()
    public void presenceGoodsInCart() throws InterruptedException {
        Waiters.waitForVisibility(productFormPage.chooseGlobalItemCategory());
        productFormPage.chooseGlobalItemCategory().click();
        productFormPage.chooseItemCategory().click();
        productFormPage.chooseItem().click();
        nameItemInShop = productFormPage.getNameItemInShop().getText();
        productFormPage.getBuyButton().click();
        productFormPage.getOrderCartButton().click();
        nameItemInCart =  productFormPage.getNameItemInCart().getText();
    }
}
