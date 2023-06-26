import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

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
        registrationFormPage.clickCommonRegFormButton();
        registrationFormPage.clickRegFormButton();
        Thread.sleep(3000);
        registrationFormPage.enterRegMobileNumber("293305742");
        registrationFormPage.setRegisterCheckbox();
        registrationFormPage.clickRegisterButton();
        Thread.sleep(3000);
        Assert.assertTrue(registrationFormPage.getErrorAlreadyText().contains("уже зарегистрирован"));
    }
    @Test
    public void checkWrongLoginFormData() throws InterruptedException {
        registrationFormPage.clickCommonRegFormButton();
        registrationFormPage.enterLogMobileNumber("293305742");
        registrationFormPage.enterLogPassword("aaa");
        registrationFormPage.setLoginCheckbox();
        registrationFormPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertTrue(registrationFormPage.getErrorWrongText().contains("Неверный"));
    }
    @Test
    public void checkTrueLoginFormData() throws InterruptedException {
        registrationFormPage.clickCommonRegFormButton();
        registrationFormPage.enterLogMobileNumber("293305742");
        registrationFormPage.enterLogPassword("c114b9b2");
        registrationFormPage.setLoginCheckbox();
        registrationFormPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertTrue(registrationFormPage.getaccountOwnerNameTextText().contains("Зинчук Александр Борисович"));
    }
}