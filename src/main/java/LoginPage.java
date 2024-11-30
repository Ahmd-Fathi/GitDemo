import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class representing the "Login" page.
 * This class contains methods to interact with elements on the page.
 */
public class LoginPage {

    WebDriver driver;

    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the "Email" field
    private By EmailField = By.id("Email");


    // Locator for the "Password" field

    private By PasswordField = By.id("inputPassword");

    // Locator for the "Login" button

    private By loginBtn = By.xpath("//input[@value=\" Log in\"]");

    /**
     * Sets the value for the "Email" field.
     * This method finds the "Email" field using its locator and sets its value.
     *
     * @param Email The email address to set in the "Email" field.
     */
    public void setEmailField(String Email) {
        driver.findElement(EmailField).sendKeys(Email);
    }

    /**
     * Sets the value for the "Password" field.
     * This method finds the "Password" field using its locator and sets its value.
     *
     * @param password The password to set in the "Password" field.
     */
    public void setPasswordField(String password) {
        driver.findElement(PasswordField).sendKeys(password);
    }

    /**
     * Clicks on the "Login" button.
     * This method finds the "Login" button using its locator and performs a click action.
     * After clicking, it returns a new instance of the HomePage.
     *
     * @return A new instance of the HomePage.
     */
    public HomePage ClickOnLoginBtn() {
        driver.findElement(loginBtn).click();
        return new HomePage(driver);


    }


}
