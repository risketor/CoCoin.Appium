package pageobjects.common;

import utilities.Core;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by A.Bartolome 09/01/2019
 */
public class Keypad extends Core {

    private final By layout_buttons_list = By.id("com.nightonke.cocoin:id/material_ripple_layout");

    /**
     * Mapping for the index in the Keypad
     *
     * 1 index 0
     * 2 index 1
     * 3 index 2
     * 4 index 3
     * 5 index 4
     * 6 index 5
     * 7 index 6
     * 8 index 7
     * 9 index 8
     * 0 index 10
     * Accept index 11
     * Delete index 9
     */

    /**
     * wait to load for the Keypad
     */
    public void waitToLoad() {
        waitForVisibility(layout_buttons_list);
        System.out.println("Keypad Loaded");
    }

    /**
     * Tap on the numbers for the password
     * N + 1 = number
     *
     * @param n
     */
    public void tapOnNumber(int n) {
        // make sure number is between 0 and 10
        Assert.assertTrue(n >= 0);
        Assert.assertTrue(n < 10);

        if (n == 0) {
            driver.findElements(layout_buttons_list).get(10).click();
            System.out.println("Tapping on number: " + 0);

        } else {
            driver.findElements(layout_buttons_list).get(n - 1).click();
            System.out.println("Tapping on number: " + n);
        }
    }

    /**
     * Tap on delete button
     */
    public void tapOnDelete() {
        driver.findElements(layout_buttons_list).get(9).click();
        System.out.println("Tapping on delete button.");
    }

    /**
     * Tap on accept button
     */
    public void tapOnAccept() {
        driver.findElements(layout_buttons_list).get(11).click();
        System.out.println("Tapping on accept button.");
    }
}