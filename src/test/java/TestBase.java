import com.google.common.io.Files;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Base class for test classes containing common setup and teardown procedures.
 */
public class TestBase {
    public static WebDriver driver;

    /**
     * Method to initialize the WebDriver based on the specified browser.
     *
     * @param browserName The name of the browser to use (Chrome, Firefox, Edge).
     */
    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("Chrome") String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://swinji.azurewebsites.net");
    }

    /**
     * Method to quit the WebDriver after all test methods in a class have run.
     *
     * @throws InterruptedException If there is an interruption during the thread sleep.
     */

    @AfterClass
    public void quiatedriver() throws InterruptedException {

        driver.quit();
    }

    /**
     * Method to capture a screenshot on test failure and save it to a specified location.
     *
     * @param result The result of the executed test method.
     */
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot camera = (TakesScreenshot) driver;
                File screenshot = camera.getScreenshotAs(OutputType.FILE);
                File destination = new File("C:\\Users\\Zone\\IdeaProjects\\Ahmed_Project\\SCREENSHOOTFOLDER\\" + result.getName() + ".png");
                org.apache.commons.io.FileUtils.copyFile(screenshot, destination);

                FileInputStream screenshotStream = new FileInputStream(destination);
                Allure.addAttachment("Screenshot", screenshotStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}































































