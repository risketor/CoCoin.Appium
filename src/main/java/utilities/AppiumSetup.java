package utilities;

import config.TestData;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;

public class AppiumSetup {

    /**
     * Create the Appium driver with specific capabilities
     * @throws MalformedURLException
     */
    public static void appiumSetup() throws MalformedURLException {
        File appDir = new File("app");
        File app = new File(appDir, "CoCoin.apk");

        // Create the driver with the capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", TestData.TestConfiguration.DeviceNVersion);
        capabilities.setCapability("deviceName", TestData.TestConfiguration.DeviceName);
        capabilities.setCapability("app", app.getAbsolutePath());
        Core.createDriver(capabilities);
    }
}
