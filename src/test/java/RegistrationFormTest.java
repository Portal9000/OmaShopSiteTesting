import org.example.driver.DriverManager;
import org.example.steps.RegistrationFormSteps;
import org.example.utils.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class RegistrationFormTest extends BaseTest {

    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(driver);
    }
    @Test(description = "Check registration form data - already registrated")
    public void checkRegistrationFormData() throws InterruptedException {
        registrationFormSteps.fillRegisterForm();
        Thread.sleep(3000);
        Assert.assertTrue(registrationFormSteps.getErrorAlreadyText().contains("уже зарегистрирован"));
    }
}