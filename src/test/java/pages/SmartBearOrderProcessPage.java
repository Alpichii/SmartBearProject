package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderProcessPage {
    public SmartBearOrderProcessPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropDown;

    @FindBy(xpath = "//input[contains(@type,'text')]")
    public List<WebElement> inputBoxes;

    @FindBy(xpath = "//table[@class='RadioList']//input")
    public List<WebElement> radioButtons;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    public void userAddressInfo(){
        inputBoxes.get(4).sendKeys("John Doe");
        inputBoxes.get(5).sendKeys("123 W Abc Ave");
        inputBoxes.get(6).sendKeys("Chicago");
        inputBoxes.get(7).sendKeys("IL");
        inputBoxes.get(8).sendKeys("60625");
    }

    public void userPaymentInfo(){
        radioButtons.get(0).click();
        inputBoxes.get(9).sendKeys("12345");
        inputBoxes.get(10).sendKeys("12/23");
    }
}