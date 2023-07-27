import org.example.driver.DriverManager;
import org.example.steps.RegistrationFormSteps;
import org.example.steps.SendingGoodsToCartSteps;
import org.example.utils.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class SendItemToCartTest extends BaseTest {

    protected WebDriver driver;
    private SendingGoodsToCartSteps sendingGoodsToCartSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        sendingGoodsToCartSteps = new SendingGoodsToCartSteps(driver);
    }
    @Test(description = "Check sending goods to the cart")
    public void presenceGoodsInCart() throws InterruptedException {
        sendingGoodsToCartSteps.presenceGoodsInCart();
        Assert.assertEquals(sendingGoodsToCartSteps.nameItemInShop, sendingGoodsToCartSteps.nameItemInCart);

//        Assert.assertEquals(registrationFormPage.getNameItemInShop(), registrationFormPage.getNameItemInCart());
//        Assert.assertTrue(registrationFormPage.getNameItemInShop().equals(registrationFormPage.getNameItemInCart()));
    }
}
