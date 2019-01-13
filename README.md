#  CoCoin Android App - Appium Tests- REST Assured Test Suite for Best Buy API Playground 
=======

Test suite covering the Appium Tests for the CoCoin Android app. 

## Solution
Automation framework based in Page Object Model using Appium to run few test cases for the CoCoin Android app. It includes 4 test cases covering some main functionality in the app. 

## Getting Started
1. Open a terminal window/command prompt
2. Clone this project.
3. In exclipse or intellij IDE import as an existing maven project
4. Rebuild
 
### Prerequisites
1. Appium set up, download and install. http://appium.io/ and start it with http://127.0.0.1:4723/ and port 4723.
2. Android SDK and set the android environment variables. Android Studio is an easy way: https://developer.android.com/studio/
3. Android device. Usually this is the problematic part. I did it using in Intellij (AVD) in my case, creating a virtual device, and updating the name and version of the device in TestData file in Config folder of the repository. It can be done with a real device too connected with USB and ADB drivers.

## Running the test suite
1. Appium server running on (http://127.0.0.1:4723/ and port 4723).
2. Device connected.
3. It is a Maven project, so reimporting all the project is the first thing to do. 
4. "CoCoin_Suite_Test",right click, and run.

## Built With
* Appium open source test automation framework
* Junit
* Maven(https://maven.apache.org/) - Dependency Management.
* Eclipse IDE Version 2018.2

## Framework components
- MAVEN This project is created as maven project. All the libraries required are maintained in "pom.xml" file as a dependencies. On importing as a Maven project it will donload all the dependencies.
- Selenium and Appium. Selenium and and appium is been used for automating UI actions on mobile application.
- Every page is a class and by creating object of page methods can be called while developing tests.
- TestData, it is a file which maintains the test data needed for test cases and the configuration for running the tests.
- Core, this is the base page of framework in which the UI operations methods are available (swipe, wait...) which can be called in creating other pages and the driver is created and kept.  
- Pages, one class per page (Page Object Model) where all the actions with the elements of that page are located.

## Improvements
Improvements to be done with more time:
* Having different files for test user data, environment configuration, runner, etc.
* Test reports in files.

## Contact
If you have any questions about this repo, please do not hesitate to contact me.
