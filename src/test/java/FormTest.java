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
        driver.get("https://demoqa.com/automation-practice-form");
        registrationFormPage = new RegistrationFormPage(driver, wait);
    }

    @Test
    public void checkRegistrationFormData() {
        registrationFormPage.enterFirstName("Sasha");
        registrationFormPage.enterLastName("Zin");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1234567890");
        registrationFormPage.clickSubmitButton();
        Assert.assertTrue(registrationFormPage.getUserDataText().contains("Sasha Zin"));

    }
}