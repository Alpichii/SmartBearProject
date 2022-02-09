package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.SmartBearSteps;

public class SmartBearHomePage extends SmartBearSteps {
    public SmartBearHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    private final String invalidUserNameInput = "abcd";
    private final String invalidPasswordInput = "abcd1234";

    private final String validUserNameInput = "Tester";
    private final String validPasswordInput = "test";

    public String getInvalidUserNameInput() {
        return invalidUserNameInput;
    }

    public String getInvalidPasswordInput() {
        return invalidPasswordInput;
    }

    public String getValidUserNameInput() {
        return validUserNameInput;
    }

    public String getValidPasswordInput() {
        return validPasswordInput;
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement userName;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@id='ctl00_MainContent_status']")
    public WebElement invalidMessage;

    public void userNamePassword(String key) {
        switch (key) {
            case invalidUserNameInput:
                userName.sendKeys(getInvalidUserNameInput());
                break;
            case invalidPasswordInput:
                password.sendKeys(getInvalidPasswordInput());
                break;
            case validUserNameInput:
                userName.sendKeys(getValidUserNameInput());
                break;
            case validPasswordInput:
                password.sendKeys(getValidPasswordInput());
                break;
            default:
        }
    }
}
