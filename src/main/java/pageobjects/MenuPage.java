package pageobjects;

import org.openqa.selenium.By;
import utilities.Core;

/**
 * Created by A.Bartolome 10/01/2019
 */
public class MenuPage extends Core {

    private final By profile_button = By.id("com.nightonke.cocoin:id/profile_image");
    private final By custom_view_button= By.id("com.nightonke.cocoin:id/custom_text");
    private final By tag_view_button = By.id("com.nightonke.cocoin:id/tag_text");
    private final By month_view_button = By.id("com.nightonke.cocoin:id/month_text");
    private final By list_view_button = By.id("com.nightonke.cocoin:id/list_text");
    private final By report_view_button = By.id("com.nightonke.cocoin:id/report_text");
    private final By settings_view_button = By.id("com.nightonke.cocoin:id/settings_text");

    private final By menu_burger_button_pwdNotPassed = By.id("com.nightonke.cocoin:id/content_hamburger");
    private final By menu_burger_button_pwdPassed = By.className("android.widget.ImageButton");


    public void waitToLoad() {
        waitForVisibility(custom_view_button);
        waitForVisibility(tag_view_button);
        waitForVisibility(month_view_button);
        waitForVisibility(list_view_button);
        waitForVisibility(report_view_button);
        waitForVisibility(settings_view_button);
        waitForVisibility(profile_button);

        System.out.println("Menu Loaded");
    }

    public void tapOnCustomView(){
        driver.findElement(custom_view_button).click();
    }

    public void tapOnTagView() {
        driver.findElement(tag_view_button).click();
    }

    public void tapOnMonthView() {
        driver.findElement(month_view_button).click();
    }

    public void tapOnListView(){
        driver.findElement(list_view_button).click();
    }


    /**
     * Section for opening the Menu button, as it seems the "burger" button has different selector (id/className) depending
     * if the user has entered the password or not
     *
     */

    public void openMenu_pwdPassed() {
            waitForVisibility(menu_burger_button_pwdPassed);
            driver.findElement(menu_burger_button_pwdPassed).click();
    }

    public void openMenu_pwdNotPassed() {
        waitForVisibility(menu_burger_button_pwdNotPassed);
        driver.findElement(menu_burger_button_pwdNotPassed).click();
    }
}