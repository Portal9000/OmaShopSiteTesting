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
    public void checkRegistrationFormData() {
        registrationFormPage.clickCommonRegFormButton();
        registrationFormPage.clickRegFormButton();
        registrationFormPage.enterMobileNumber("293305742");
        registrationFormPage.setRegisterCheckbox();
        registrationFormPage.clickRegisterButton();
        Assert.assertTrue(registrationFormPage.getErrorAlreadyText().contains("уже зарегистрирован"));
    }
}