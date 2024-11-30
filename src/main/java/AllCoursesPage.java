import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllCoursesPage {
    WebDriver driver;

    // Constructor to initialize the WebDriver
    public AllCoursesPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locator for the "Add Course" button
    private By AddCourseBtn = By.id("btnListAddCourse");

    /**
     * Clicks on the "Add Course" button.
     * This method finds the "Add Course" button using its locator and performs a click action.
     * It assumes that the button is present and clickable.
     */
    public void ClickAddCourseBtn() {
        driver.findElement(AddCourseBtn).click();
    }


}
