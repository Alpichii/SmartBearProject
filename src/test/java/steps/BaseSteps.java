package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.Waiter;

public class BaseSteps {

    public WebDriver driver;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
        Waiter.pause(2);
    }
}

