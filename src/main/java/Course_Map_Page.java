import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class representing the "Course Map" page.
 * This class contains methods to interact with elements on the page.
 */
public class Course_Map_Page {
    WebDriver driver;

    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public Course_Map_Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the "Course Name" element
    private By CourseName = By.id("courseNameView");


    /**
     * Retrieves the text content of the "Course Name" element.
     * This method finds the "Course Name" element using its locator and returns its text content.
     *
     * @return The text content of the "Course Name" element.
     */
    public String getTxt() {
        return driver.findElement(CourseName).getText();
    }


}
