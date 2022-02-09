package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHandler {
    private static WebDriver driver = Driver.getDriver();
    private static Alert alert = driver.switchTo().alert();

    public static void acceptAlert(){
        alert.accept();
    }

    public static void dismissAlert(){
        alert.dismiss();
    }

    public static void sendKeysToAlert(String keys){
        alert.sendKeys(keys);
    }

    public static String getAlertText(){
        return alert.getText();
    }

    public static void sendKeysAndAccept(String keys){
        sendKeysToAlert(keys);
        acceptAlert();
    }
}