package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public abstract class Page {

    protected WebDriver driver;
    protected String baseUrl = "http://vk.com/";

    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public abstract void open();

    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
