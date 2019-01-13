package pageobjects;

import org.openqa.selenium.By;
import utilities.Core;

/**
 * Created by A.Bartolome 12/01/2019
 */
public class ListViewPage extends Core {

    private final By money_id = By.id("com.nightonke.cocoin:id/money");


    public void waitToLoad() {
        waitForVisibility(money_id);

        System.out.println("List View Loaded");
    }

    /**
     * Get the amount displayed for entry i
     * Remove all non numeric characters.
     * @param i
     * @return
     */
    public int getAmountForEntry(int i){
        String s = driver.findElements(money_id).get(i).getText();
        s = s.replaceAll("[^\\d.]", "");
        return Integer.parseInt(s);
    }

    public boolean checkEntryIsDisplayed(int i){
        return driver.findElements(money_id).get(i).isDisplayed();
    }

    public void deleteEntry(int i){
        swipeLeftToRightOnElement(driver.findElements(money_id).get(i));
        System.out.println("Deleted entry: " + i);
    }

    public void editEntry(int i){
        swipeRightToLeftOnElement(driver.findElements(money_id).get(i));
        System.out.println("Editing entry: " + i);

    }

    public void deleteEntry1(int i){
        swipeLeftToRightOnElement1(driver.findElements(money_id).get(i));
        System.out.println("Deleted entry: " + i);
    }

    public void deleteEntry2(int i){
        swipeLeftToRightOnElement2(driver.findElements(money_id).get(i));
        System.out.println("Deleted entry: " + i);
    }

    public void deleteEntry3(int i){
        swipeLeftToRightOnElement3(driver.findElements(money_id).get(i));
        System.out.println("Deleted entry: " + i);
    }

    public void deleteEntry4(int i){
        swipeLeftToRightOnElement4(driver.findElements(money_id).get(i));
        System.out.println("Deleted entry: " + i);
    }
}