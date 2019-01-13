package pageobjects;

import org.openqa.selenium.By;
import utilities.Core;

/**
 * Created by A.Bartolome 12/01/2019
 */
public class MonthViewPage extends Core {

    private final By money_id = By.id("com.nightonke.cocoin:id/expanse");


    public void waitToLoad() {
        waitForVisibility(money_id);
        System.out.println("Month View Loaded");
    }

    /**
     * Get the amount displayed
     * Remove all non numeric characters.
     * @return
     */
    public int getAmount(){
        String s = driver.findElement(money_id).getText();
        s = s.replaceAll("[^\\d.]", "");
        return Integer.parseInt(s);
    }
}