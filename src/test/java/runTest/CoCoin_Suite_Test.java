package runTest;

import org.junit.*;
import org.openqa.selenium.support.PageFactory;
import pageobjects.*;
import pageobjects.common.Keypad;
import utilities.AppiumSetup;
import utilities.Core;
import config.TestData;
import java.net.MalformedURLException;


/**
* Created by A.Bartolome 10/01/2019
*/
public class CoCoin_Suite_Test extends Core {

    public EntryPage entryPage;
    public Keypad keypad;
    public IntroPage introPage;
    public LandingPage landingPage;
    public MenuPage menuPage;
    public ListViewPage listViewPage;
    public MonthViewPage monthViewPage;
    public TagViewPage tagViewPage;

    public CoCoin_Suite_Test() {
        entryPage = PageFactory.initElements(driver, EntryPage.class);
        keypad = PageFactory.initElements(driver, Keypad.class);
        introPage = PageFactory.initElements(driver, IntroPage.class);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        menuPage = PageFactory.initElements(driver, MenuPage.class);
        listViewPage = PageFactory.initElements(driver, ListViewPage.class);
        monthViewPage = PageFactory.initElements(driver, MonthViewPage.class);
        tagViewPage = PageFactory.initElements(driver, TagViewPage.class);
    }

    /**
     * Before starting each test, the Appium driver will be created
     * the intro will be skipped
     * and a new password will be entered.
     *
     * @throws InterruptedException
     * @throws MalformedURLException
     */
    @Before
    public void setupBefore() throws InterruptedException, MalformedURLException {
        AppiumSetup.appiumSetup();
        skipIntro();
        enterNewPassword();
    }

    /**
     * After each test in this class, the driver will be killed
     * @throws Exception
     */
    @After
    public void tearDownAfter(){
        Core.quitDriver();
    }



    // TEST CASES

    /**
     * Enter a new entry two times
     * Open Menu
     * Pwd is asked again
     * Check both entries in the Landing page
     * Open Menu / List View
     * Check both entries in List View
     * Delete one.
     *
     */
    @Test
    public void EnterNewEntryTwice_CheckOnListView_DeleteOne_Test_1(){

        // Make the same new entry two times
        newEntry();
        newEntry();

        // Open the Menu
        menuPage.openMenu_pwdNotPassed();

        // Password is asked again
        enterPassword();

        // Landing Page is displayed
        landingPage.waitToLoad();

        // Check that it is displayed the amount of the entry x 2 in the landing page
        int new_amount = TestData.NewEntry.AmountAllDigits*2;
        Assert.assertTrue(landingPage.getAmountForEntry(0)==new_amount);

        // Open the Menu (now it doesn't ask for password)
        menuPage.openMenu_pwdPassed();

        // List View Page
        menuPage.waitToLoad();
        menuPage.tapOnListView();
        listViewPage.waitToLoad();

        // Assert that the listed amounts 1 and 2 are the previously entered ones
        Assert.assertTrue(listViewPage.getAmountForEntry(0) == TestData.NewEntry.AmountAllDigits);
        Assert.assertTrue(listViewPage.getAmountForEntry(1) == TestData.NewEntry.AmountAllDigits);

        System.out.println("Amounts are correct, for 0 position: " + TestData.NewEntry.AmountAllDigits);
        System.out.println("Amounts are correct, for 1 position: " + TestData.NewEntry.AmountAllDigits);

        // Assert entry 1 is displayed.
        Assert.assertTrue(listViewPage.checkEntryIsDisplayed(1));

        listViewPage.deleteEntry(1);

        listViewPage.deleteEntry1(1);

        listViewPage.deleteEntry2(1);

        listViewPage.deleteEntry3(1);

        listViewPage.deleteEntry4(1);


        // Assert entry 1 is NOT displayed.
        Assert.assertTrue(!listViewPage.checkEntryIsDisplayed(1));
    }

    /**
     * Enter a new entry two times
     * Open Menu
     * Pwd is asked again
     * Check both entries in the Landing page
     * Open Menu / List View
     * Check both entries in List View
     * Delete one.
     *
     */
    @Test
    public void EnterNewEntry_CheckOnListView_Edit_Test_2(){

        // Make the same new entry two times
        newEntry();

        // Open the Menu
        menuPage.openMenu_pwdNotPassed();

        // Password is asked again
        enterPassword();

        // Landing Page is displayed
        landingPage.waitToLoad();

        // Check that it is displayed the amount of the entry x 2 in the landing page
        Assert.assertTrue(landingPage.getAmountForEntry(0)==TestData.NewEntry.AmountAllDigits);

        // Open the Menu (now it doesn't ask for password)
        menuPage.openMenu_pwdPassed();

        // List View Page
        menuPage.waitToLoad();
        menuPage.tapOnListView();
        listViewPage.waitToLoad();

        // Assert that the listed amounts 1 and 2 are the previously entered ones
        Assert.assertTrue(listViewPage.getAmountForEntry(0) == TestData.NewEntry.AmountAllDigits);

        System.out.println("Amounts are correct, for 0 position: " + TestData.NewEntry.AmountAllDigits);

        // Swipe to edit the entry, and enter new value in the keypad
        listViewPage.editEntry(0);
        keypad.tapOnNumber(6);
        keypad.tapOnNumber(6);
        keypad.tapOnAccept();

        // Assert new value displayed in List View is the updated one.
        Assert.assertTrue(listViewPage.getAmountForEntry(0) == 66);
    }

    /**
     * Enter a new entry
     * Open Menu
     * Pwd is asked again
     * Open Menu / List View
     * Check entry in Month View
     *
     */
    @Test
    public void EnterNewEntry_MonthlyView_Test_3() {

        // Make a new entry
        newEntry();

        // Open Menu (entering pwd again)
        menuPage.openMenu_pwdNotPassed();
        enterPassword();
        menuPage.openMenu_pwdPassed();
        menuPage.waitToLoad();

        // Open Month View
        menuPage.tapOnMonthView();
        monthViewPage.waitToLoad();

        // Assert that previously entered amount is listed in Month View
        Assert.assertTrue(monthViewPage.getAmount() == TestData.NewEntry.AmountAllDigits);
    }

    /**
     * Enter a new entry
     * Open Menu
     * Pwd is asked again
     * Open Menu / Tag View
     * Check entry in Tag View
     *
     */
    @Test
    public void EnterNewEntry_TagView_Test_4() {

        // Make a new entry
        newEntry();

        // Open Menu (entering pwd again)
        menuPage.openMenu_pwdNotPassed();
        enterPassword();
        menuPage.openMenu_pwdPassed();
        menuPage.waitToLoad();

        // Open Tag View
        menuPage.tapOnTagView();
        tagViewPage.waitToLoad();

        // Assert that previously entered amount is listed in Month View
        Assert.assertTrue(tagViewPage.getAmount() == TestData.NewEntry.AmountAllDigits);
    }



    // USEFUL METHODS TO HELP WITH THE TESTS

    /**
     * Entering the numbers from the Password to use from Test Data
     */
    public void enterPassword(){
        keypad.tapOnNumber(TestData.PasswordToUse.Digit_1);
        keypad.tapOnNumber(TestData.PasswordToUse.Digit_2);
        keypad.tapOnNumber(TestData.PasswordToUse.Digit_3);
        keypad.tapOnNumber(TestData.PasswordToUse.Digit_4);
    }

    /**
     * Keypad - wait to load and enter the password for first time twice
     */
    private void enterNewPassword() {
        keypad.waitToLoad();
        enterPassword();
        enterPassword();
    }

    /**
     * Intro Page - skip the intro page swiping from right to left
     * @throws InterruptedException
     */
    private void skipIntro() throws InterruptedException {
        introPage.skipIntro();
    }

    /**
     * New entry into the system with amount and tag from Test Data
     */
    private void newEntry() {
        entryPage.waitToLoad();

        keypad.tapOnNumber(TestData.NewEntry.Digit_1);
        keypad.tapOnNumber(TestData.NewEntry.Digit_2);
        keypad.tapOnNumber(TestData.NewEntry.Digit_3);
        // Assert that the entered amount is the displayed one
        Assert.assertTrue(entryPage.getAmount() == TestData.NewEntry.AmountAllDigits);
        entryPage.tapOnCategory(TestData.NewEntry.TagToUse);
        keypad.tapOnAccept();
        // Assert that amount is 0 after having entered the previous one.
        Assert.assertTrue(entryPage.getAmount()==0);
    }
}