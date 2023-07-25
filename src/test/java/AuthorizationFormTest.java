import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.steps.RegistrationFormSteps;
import org.example.utils.AllureListener;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class AuthorizationFormTest extends BaseTest {

    protected WebDriver driver;
    private AuthorizationFormSteps authorizationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        authorizationFormSteps = new AuthorizationFormSteps(driver);
    }

    @Test(description = "Check registration form data", dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormData(UserData userData) {
        authorizationFormSteps.fillForm(userData);
//        Assert.assertTrue(registrationFormSteps.getUserDataText().contains("Ivanov"));
        Assert.assertTrue(authorizationFormSteps.getUserDataText().contains(userData.getFirstName()));
    }
}