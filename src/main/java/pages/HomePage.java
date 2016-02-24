package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @FindBy(id = "logout_link")
    public WebElement linkSignOut;

    public boolean isLoggedIn() {
        return isElementPresent(linkSignOut);
    }

    public LoginPage logOut() {
        linkSignOut.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
