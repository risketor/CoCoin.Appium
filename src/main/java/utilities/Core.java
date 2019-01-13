package utilities;

import config.TestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
     * Swipe from Right to Left 95% to 05% width
     */
    public void swipeRightToLeft()  {

        Dimension dims = driver.manage().window().getSize();
        int x = (int) (dims.getWidth() * 0.95);
        int endx = (int) (dims.getWidth() * 0.05);
        int y = (int) (dims.getHeight() * 0.30);

        new TouchAction(driver)
                .longPress(new PointOption().withCoordinates(x, y))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
                .moveTo(new PointOption().withCoordinates(endx, y))
                .release()
                .perform();
        System.out.println("Swiping right to left.");
    }

    /**
     * Swipe from Right to Left 99% to 5% width
     */
    public void swipeRightToLeftOnElement(WebElement element)  {
        Point location = element.getLocation();
        int y = location.y;

        Dimension dims = driver.manage().window().getSize();
        int x = (int) (dims.getWidth() * 0.99);
        int endx = (int) (dims.getWidth() * 0.05);

        new TouchAction(driver)
                .press(new PointOption().withCoordinates(x, y))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(150)))
                .moveTo(new PointOption().withCoordinates(endx, y))
                .release()
                .perform();
        System.out.println("Swiping right to left.");
    }


    /**
     * Swipe from Left to Right 5% to 99% width
     */
    public void swipeLeftToRightOnElement(WebElement element)  {

        Point location = element.getLocation();
        int y = location.y;

        Dimension dims = driver.manage().window().getSize();
        int x = (int) (dims.getWidth() * 0.05);
        int endx = (int) (dims.getWidth() * 0.99);

        new TouchAction(driver)
                .press(new PointOption().withCoordinates(x, y))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(200)))
                .moveTo(new PointOption().withCoordinates(endx, y))
                .release()
                .perform();
        System.out.println("Swiping left to right. " );
    }
}