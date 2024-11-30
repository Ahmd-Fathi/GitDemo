import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page class representing the "Navigate Course Details" page.
 * This class contains methods to interact with elements on the page.
 */
public class NavigateCourseDetailsPage {
    WebDriver driver;
    // Locator for the "Course Grade" dropdown

    private By CourseGrade = By.id("courseGrade");

    // Locator for the course teacher element

    private By courseTeacher = By.cssSelector("span[class=\"ui-select-choices-row-inner\"]");

    // Locator for the "Create" button

    private By Create_Button = By.id("btnSaveAsDraftCourse");

    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver The WebDriver instance used to interact with the browser.
     */
    public NavigateCourseDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locator for the "Course Name" field
    private By CourseNameField = By.id("txtCourseName");

    // Locator for the "Course Subject" dropdown

    private By courseSubject = By.id("courseSubject");


    /**
     * Fills in the details for creating a new course.
     * This method finds the relevant elements using their locators and performs actions such as entering text,
     * selecting options from dropdowns, and clicking buttons.
     *
     * @param Course_Name The name of the course to be filled in the "Course Name" field.
     * @throws InterruptedException If there is an interruption during the thread sleep.
     */
    public void FillCourseDetails(String Course_Name) throws InterruptedException {
        driver.findElement(CourseNameField).sendKeys(Course_Name);
        Select select = new Select(driver.findElement(courseSubject));
        select.selectByIndex(3);
        Select selectGrade = new Select(driver.findElement(CourseGrade));
        selectGrade.selectByIndex(3);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait for the element with the specified CSS selector to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class=\"ui-select-placeholder text-muted\"]"))).click();

// Wait for the courseTeacher element to be present and clickable, then click
        wait.until(ExpectedConditions.elementToBeClickable(courseTeacher)).click();

// Wait for the Create Button to be clickable, then click
        wait.until(ExpectedConditions.elementToBeClickable(Create_Button)).click();


    }
}
