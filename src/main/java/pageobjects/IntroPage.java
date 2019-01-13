package pageobjects;

import utilities.Core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by A.Bartolome 09/01/2019
 *
 */
public class IntroPage extends Core {

    // Elements displayed in the Intro page
    private @FindBy(id="com.nightonke.cocoin:id/icon_11") WebElement intro_element_2;
    private @FindBy(id="com.nightonke.cocoin:id/icon_12") WebElement intro_element_3;
    private @FindBy(id="com.nightonke.cocoin:id/icon_19") WebElement intro_element_4;
    private @FindBy(id="navigationBarBackground") WebElement splash;
    private final By splashScreen = By.id("navigationBarBackground");
    private final By firstInformationScreen = By.className("android.widget.ImageView");
    private final By intro_element_1 = By.id("com.nightonke.cocoin:id/icon_4");


    /**
     * Skip the intro swiping to the left 4 times once the splash image is loaded
     * @throws InterruptedException
     */
    public void skipIntro() throws InterruptedException {
        waitForVisibility(splashScreen);
        waitForVisibility(firstInformationScreen);
        waitForVisibility(intro_element_1);

        System.out.println("Intro page loaded.");

        // Swipe right to left 4 times
        swipeRightToLeft();
        swipeRightToLeft();
        swipeRightToLeft();
        swipeRightToLeft();

    }
}
