package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SmartBearWebOrderPage {
    public SmartBearWebOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_menu > li")
    public List<WebElement> listOfMenu;

    @FindBy(xpath = "//table[@class='SampleTable']//td[1]/input")
    public List<WebElement> checkBoxes;

    @FindBy(css = ".CheckUncheck > a")
    public List<WebElement> unCheckAllBoxes;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody[1]/tr[2]/td[5]")
    public WebElement currentOrderDate;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_btnDelete']")
    public WebElement deleteButton;



    @FindBy(xpath = "(//table[@id='ctl00_MainContent_orderGrid']//tr)[1]/th")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "(//table[@id='ctl00_MainContent_orderGrid']//tr)[2]/td")
    public List<WebElement> tableRow1;

    @FindBy(id = "ctl00_MainContent_orderGrid")
    public WebElement table;

    @FindBy(tagName = "h2")
    public WebElement listOfAllOrdersTitle;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement emptyMessage;

    public List<List<WebElement>> getTableDataLists(){
        List<List<WebElement>> dataTableList = new ArrayList<>();
        dataTableList.add(tableHeaders);
        dataTableList.add(tableRow1);

        return dataTableList;
    }

    public void checkUncheck(String linkText) {
        for (WebElement link : unCheckAllBoxes) {
            if (link.getText().equals(linkText)) {
                link.click();
                break;
            }
        }
    }

    public Map<Object, Object> unCheckAllBoxes() {
        return null;
    }
}