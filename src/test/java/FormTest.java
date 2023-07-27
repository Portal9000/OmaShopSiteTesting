import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.Collections;

public class FormTest {
    private RegistrationFormPage registrationFormPage;
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.oma.by/");
        registrationFormPage = new RegistrationFormPage(driver, wait);
    }

    @Test
    public void checkRegistrationFormData() throws InterruptedException {
        registrationFormPage.clickChooseGlobalItemCategoryButton();
        registrationFormPage.clickChooseItemCategoryButton();
        registrationFormPage.clickChooseItem();

        registrationFormPage.clickBuyButton();
        Thread.sleep(5000);
        registrationFormPage.clickShut();
        registrationFormPage.clickOrderCartButton();

//        Assert.assertEquals(registrationFormPage.getNameItemInShop(), registrationFormPage.getNameItemInCart());

//        Assert.assertTrue(registrationFormPage.getNameItemInShop().equals(registrationFormPage.getNameItemInCart()));
    }
}