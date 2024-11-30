import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class representing the "Home" page.
 * This class contains methods to interact with elements on the page.
 */
public class HomePage {
    WebDriver driver;

    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the "Courses" icon in the navigation bar
    private By coursesIconNavigationBar = By.xpath("(//a[em[@class='fa-lg fa-fw fal fa-desktop-alt']])[1]");


    // Locator for asserting that the home page is displayed

    public By assertHomePageDisplayed = By.id("lblTenantDisplayName");

    /**
     * Retrieves the text content for asserting the home page.
     * This method finds the element for asserting the home page using its locator and returns its text content.
     *
     * @return The text content for asserting the home page.
     */
    private String assertHomePage() {
        return driver.findElement(assertHomePageDisplayed).getText();

    }

    /**
     * Clicks on the "Courses" icon in the navigation bar.
     * This method finds the "Courses" icon using its locator and performs a click action.
     * After clicking, it returns a new instance of the AllCoursesPage.
     *
     * @return A new instance of the AllCoursesPage.
     */
    public AllCoursesPage ClickCoursesIconNavigationBar() {
        driver.findElement(coursesIconNavigationBar).click();
        return new AllCoursesPage(driver);

    }


}
