import org.example.driver.DriverManager;
import org.example.steps.AuthorizationFormSteps;
import org.example.utils.AllureListener;
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

    @Test(description = "Check registration form data - wrong password")
    public void checkAuthorizationWithWrongPass() {
        authorizationFormSteps.checkWrongPassFormData();
        Assert.assertTrue(authorizationFormSteps.getErrorWrongPasswordText().contains("Неверный"));
    }

    @Test(description = "Check registration form data - correct account owner name")
    public void checkTrueLoginFormData() {
        authorizationFormSteps.checkTrueLoginFormData();
        Assert.assertTrue(authorizationFormSteps.getAccountOwnerName().contains("Зинчук Александр Борисович"));
    }

    @Test(description = "Check registration form data - wrong account owner name")
    public void checkWrongNameFormData() {
        authorizationFormSteps.checkWrongNameFormData();
        Assert.assertTrue(authorizationFormSteps.getAccountOwnerName().contains("Миша Джексон"));
    }
}