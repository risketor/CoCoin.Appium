package pageobjects;

import org.openqa.selenium.By;
import utilities.Core;

/**
 * Created by A.Bartolome 12/01/2019
 */
public class LandingPage extends Core {

    private final By logo = By.id("com.nightonke.cocoin:id/logo_white");
    private final By days_button= By.id("com.nightonke.cocoin:id/psts_tab_title");
    private final By amount = By.id("com.nightonke.cocoin:id/expanse");

    public void waitToLoad() {
        waitForVisibility(logo);
        waitForVisibility(days_button);
        waitForVisibility(amount);

        System.out.println("Landing page Loaded");
    }

    /**
     * Get the amount displayed for entry i
     * Remove all non numeric characters.
     * @param i
     * @return
     */
    public int getAmountForEntry(int i){
        String s = driver.findElements(amount).get(i).getText();
        s = s.replaceAll("[^\\d.]", "");
        return Integer.parseInt(s);
    }
}