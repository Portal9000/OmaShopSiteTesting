import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class AuthorizationFormTest {

    private AuthorizationFormPage authorizationFormPage;
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.oma.by/");
        authorizationFormPage = new AuthorizationFormPage(driver, wait);
    }

    @Test
    public void checkWrongLoginFormData() throws InterruptedException {
        authorizationFormPage.clickCommonRegFormButton();
        authorizationFormPage.enterLogMobileNumber("293305742");
        authorizationFormPage.enterLogPassword("aaa");
        authorizationFormPage.setLoginCheckbox();
        authorizationFormPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertTrue(authorizationFormPage.getErrorWrongText().contains("Неверный"));
    }
    @Test
    public void checkTrueLoginFormData() throws InterruptedException {
        authorizationFormPage.clickCommonRegFormButton();
        authorizationFormPage.enterLogMobileNumber("293305742");
        authorizationFormPage.enterLogPassword("c114b9b2");
        authorizationFormPage.setLoginCheckbox();
        authorizationFormPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertTrue(authorizationFormPage.getaccountOwnerNameTextText().contains("Зинчук Александр Борисович"));
    }
    @Test
    public void checkWrongNameFormData() throws InterruptedException {
        authorizationFormPage.clickCommonRegFormButton();
        authorizationFormPage.enterLogMobileNumber("293305742");
        authorizationFormPage.enterLogPassword("c114b9b2");
        authorizationFormPage.setLoginCheckbox();
        authorizationFormPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertTrue(authorizationFormPage.getaccountOwnerNameTextText().contains("Миша Джексон"));
    }
}