package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Core;

/**
 * Created by A.Bartolome 12/01/2019
 */
public class EntryPage extends Core {

    private final By amount_field = By.id("com.nightonke.cocoin:id/money");
    private final By tag_id = By.id("com.nightonke.cocoin:id/tag_name");

    public void waitToLoad() {
        waitForVisibility(amount_field);
        waitForVisibility(tag_id);
        System.out.println("Entry Page Loaded");
    }

    /**
     * Get amount displayed in the calculator
     * @return
     */
    public int getAmount(){
        String s = driver.findElement(amount_field).getText();
        System.out.println("AMOUNT " + s);
        s = s.replaceAll("[^\\d.]", "");
        return Integer.parseInt(s);
    }

    public void getAllTags(){
        int i = 0 ;
        for(WebElement ele : driver.findElements(tag_id)){
            ele.getText();
            System.out.println(i + " tag " + ele.getText());
            i++;
        }
    }

    /**
     * Tap on a specific category
     * @param tag_name
     */
    public void tapOnCategory(String tag_name){
        boolean flag = false;
        for(WebElement ele : driver.findElements(tag_id)){
            if(ele.getText().contains(tag_name)){
                ele.click();
                flag = true;
                // System.out.println("Tapping on tag " + ele.getText());
            }
        }

        if(!flag){
            System.out.println("Tag Not found: " + tag_name);
        }
    }
}