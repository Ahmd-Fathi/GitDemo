import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class for the login functionality and course-related actions.
 * Extends the TestBase class to inherit common setup and teardown procedures.
 */
public class loginTest extends TestBase {
    HomePage HomeObject;
    Course_Map_Page Course_Map_object;
    NavigateCourseDetailsPage NavigateCourseDetailsObject;
    AllCoursesPage AllCoursesObject;
    LoginPage LoginObject;

    /**
     * Test case for performing login and checking the visibility of a specific element.
     *
     * @param email    The user's email.
     * @param password The user's password.
     * @throws InterruptedException If there is an interruption during the thread sleep.
     */
    @Test(dataProvider = "loginData", description = "Verify successful login and visibility of the homepage.")
    public void loginTest_1(String email, String password) throws InterruptedException {
        LoginObject = new LoginPage(driver);
        LoginObject.setEmailField(email);
        LoginObject.setPasswordField(password);
        HomePage HomePage = LoginObject.ClickOnLoginBtn();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lblTenantDisplayName"))));
        } catch (TimeoutException e) {
            Assert.fail("Timeout waiting for element with ID 'lblTenantDisplayName' to be visible");
        }
    }

    /**
     * Test case for navigating to the course page and clicking the "Add Course" button.
     *
     * @throws InterruptedException If there is an interruption during the thread sleep.
     */
    @Test(priority = 2, description = "Navigate to the course page and click the 'Add Course' button.")
    public void navigateCourseInfo() throws InterruptedException {
        HomeObject = new HomePage(driver);
        AllCoursesPage AllCoursesPage = HomeObject.ClickCoursesIconNavigationBar();
        AllCoursesPage.ClickAddCourseBtn();
    }

    /**
     * Test case for filling in course details and asserting the course information.
     *
     * @param courseName The name of the course.
     * @throws InterruptedException If there is an interruption during the thread sleep.
     */
    @Test(dataProvider = "courseData", priority = 3, description = "Fill in course details and verify course information.")
    public void FillCourseInfo(String courseName) throws InterruptedException {
        NavigateCourseDetailsObject = new NavigateCourseDetailsPage(driver);
        NavigateCourseDetailsObject.FillCourseDetails(courseName);
        Course_Map_object = new Course_Map_Page(driver);
        Assert.assertTrue(Course_Map_object.getTxt().contains(courseName));
        Assert.assertTrue(Course_Map_object.getTxt().contains(courseName));
        Assert.assertTrue(Course_Map_object.getTxt().contains(courseName));
        Assert.assertTrue(Course_Map_object.getTxt().contains(courseName));
    }

    /**
     * Data provider for login test data.
     *
     * @return 2D array with login data.
     */
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
                {"testregister@aaa.com", "Wakram_123"},
                // Add more test data as needed
        };
    }

    /**
     * Data provider for course test data.
     *
     * @return 2D array with course data.
     */
    @DataProvider(name = "courseData")
    public Object[][] provideCourseData() {
        return new Object[][]{
                {"ITWorks"},
                // Add more test data as needed
        };
    }
}
