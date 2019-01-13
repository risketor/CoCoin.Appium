package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by A.Bartolome 09/01/2019
 */
public class Core {

    // Get time out amount in seconds from Test Data config
    private static int timeOut = TestData.RunnerConfiguration.Timeout;

    // Main driver for all the tests
    public static AppiumDriver<MobileElement> driver;

    /**
     *
     * @param capabilities
     * @throws MalformedURLException
     */
    public static AppiumDriver<MobileElement> createDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * quit the driver at the end of a test
     */
    public static void quitDriver() {
        driver.quit();
    }



    /**
     * Wait for visibility for the By element
     * @param element
     */
    public static void waitForVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    /**
     * Swipe from Right to Left 90% to 10% width
     */
    public void swipeRightToLeft()  {
        Dimension size = driver.manage().window().getSize();
        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        int startx = (int) (size.width * 0.90);
        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.10);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = size.height / 3;

        //Swipe from Right to Left.
        driver.swipe(startx, starty, endx, starty, 500);
    }

    /**
     * Swipe from Left to Right 95% to 5% width
     */
    public void swipeLeftToRightOnElement(WebElement element)  {
        Dimension size = driver.manage().window().getSize();
        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        Point location = element.getLocation();
        int startx = (int) (size.width * 0.01);
        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * .99);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = location.y;
        int endy = starty;
        //Swipe from Right to Left.
        driver.swipe(startx, starty, endx, starty, endy);
    }

    /**
     * Swipe from Right to Left 95% to 5% width
     */
    public void swipeRightToLeftOnElement(WebElement element)  {
        Dimension size = driver.manage().window().getSize();
        //Find swipe start and end point from screen's with and height.
        //Find startx point which is at right side of screen.
        Point location = element.getLocation();
        int startx = (int) (size.width * 0.95);
        //Find endx point which is at left side of screen.
        int endx = (int) (size.width * 0.05);
        //Find vertical point where you wants to swipe. It is in middle of screen height.
        int starty = location.y;
        int endy = starty;
        //Swipe from Right to Left.
        driver.swipe(startx, starty, endx, starty, endy);
    }
}
