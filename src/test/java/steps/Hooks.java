package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Driver;
import utilities.ScreenshotUtils;

public class Hooks {
    @Before
    public void testSetUp(Scenario scenario) {
        System.out.println(scenario.getName() + " is started!");
    }

    //All after actions here
    @After
    public void tearDown(Scenario scenario) {

        System.out.println(scenario.getName() + "status is: " + scenario.getStatus());

        if (scenario.isFailed()) ScreenshotUtils.takeScreenshot(scenario, Driver.getDriver());

        Driver.quitDriver();
    }
}