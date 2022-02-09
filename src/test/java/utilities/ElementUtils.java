package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtils {
    private static Actions actions = new Actions(Driver.getDriver());

    public static boolean isElementDisplayed(WebElement element){
        boolean check;
        try{
            check = element.isDisplayed();
        }
        catch (NoSuchElementException e){
            check = false;
        }

        return check;
    }

    public static void rightClick(WebElement element){
        moveToElement(element);
        actions.contextClick(element).perform();
    }

    public static void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }
}