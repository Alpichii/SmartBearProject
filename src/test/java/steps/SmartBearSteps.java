package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.SmartBearHomePage;
import pages.SmartBearOrderProcessPage;
import pages.SmartBearWebOrderPage;
import texts.ExpectedTexts;
import utilities.Driver;
import utilities.DropdownUtils;
import utilities.ElementUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SmartBearSteps {

    public WebDriver driver;
    public SmartBearHomePage smartBearHomePage;
    public SmartBearWebOrderPage smartBearWebOrderPage;
    public SmartBearOrderProcessPage smartBearOrderProcessPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        smartBearHomePage = new SmartBearHomePage(driver);
        smartBearWebOrderPage = new SmartBearWebOrderPage(driver);
        smartBearOrderProcessPage = new SmartBearOrderProcessPage(driver);
    }

    @When("user enters username as {string}")
    public void userEntersUsernameAs(String input) {
        smartBearHomePage.userNamePassword(input);
    }

    @And("user enters password as {string}")
    public void userEntersPasswordAs(String input) {
        smartBearHomePage.userNamePassword(input);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearHomePage.loginButton.click();
    }

    @Then("user should see {string} Message")
    public void userShouldSeeMessage(String message) {
        Assert.assertEquals(message, smartBearHomePage.invalidMessage.getText());    }

    @Then("user should be routed to {string}")
    public void user_should_be_routed_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable dataTable) {
        List<String> expectedMenuItems = dataTable.asList();

        for (int i = 0; i < smartBearWebOrderPage.listOfMenu.size(); i++) {
            Assert.assertTrue(smartBearWebOrderPage.listOfMenu.get(i).isDisplayed());
            Assert.assertEquals(expectedMenuItems.get(i), smartBearWebOrderPage.listOfMenu.get(i).getText());
        }
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttons) {
        switch (buttons) {
            case ExpectedTexts.checkAllButton:
            case ExpectedTexts.unCheckAllButton:
                smartBearWebOrderPage.checkUncheck(buttons);
                break;
            case ExpectedTexts.deleteSelectedButton:
                smartBearWebOrderPage.deleteButton.click();
                break;
            case ExpectedTexts.processButton:
                smartBearOrderProcessPage.processButton.click();
                break;
            default:
                throw new NotFoundException(buttons + " can not be found!!!");
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        for (int i = 0; i < smartBearWebOrderPage.checkBoxes.size(); i++) {
            Assert.assertTrue(smartBearWebOrderPage.checkBoxes.get(i).isSelected());
        }
    }

    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        for (int i = 0; i < smartBearWebOrderPage.unCheckAllBoxes.size(); i++) {
            Assert.assertFalse(smartBearWebOrderPage.unCheckAllBoxes.get(i).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String key) {
        switch (key) {
            case ExpectedTexts.orderMenu:
                smartBearWebOrderPage.listOfMenu.get(2).click();
                break;
            case ExpectedTexts.viewAllOrdersMenu:
                smartBearWebOrderPage.listOfMenu.get(0).click();
                break;
            default:
                throw new NotFoundException(key + " can not be found!!!");
        }
    }

    @And("user selects {string} as product")
    public void userSelectsAsProduct(String product) {
        DropdownUtils.selectDropdownByText(smartBearOrderProcessPage.dropDown, product);
    }

    @And("user enters {int} as quantity")
    public void userEntersAsQuantity(int quantity) {
        smartBearOrderProcessPage.inputBoxes.get(0).sendKeys(String.valueOf(quantity));
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation() {
        smartBearOrderProcessPage.userAddressInfo();
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearOrderProcessPage.userPaymentInfo();
    }

    @Then("user should see their order displayed in the {string} table")
    public void userShouldSeeTheirOrderDisplayedInTheTable(String order) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Assert.assertEquals(formattedDate, smartBearWebOrderPage.currentOrderDate.getText());
    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable dataTable) {
        List<List<String>> dataLists = dataTable.asLists();
        for (int i = 1; i < smartBearWebOrderPage.getTableDataLists().size(); i++) {
            for (int j = 1; j < smartBearWebOrderPage.getTableDataLists().get(i).size(); j++) {
                if (i == 4 || j == 4)
                    continue;
                Assert.assertEquals(dataLists.get(i).get(j), smartBearWebOrderPage.getTableDataLists().get(i).get(j).getText());
            }
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validateAllOrdersAreDeletedFromThe() {
        Assert.assertTrue(smartBearWebOrderPage.deleteButton.isDisplayed());
    }

    @And("validate user sees {string} Message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, smartBearWebOrderPage.emptyMessage.getText());
    }
}