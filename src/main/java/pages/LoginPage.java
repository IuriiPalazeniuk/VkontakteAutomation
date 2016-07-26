package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import data.UserData;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class LoginPage extends Page {

    @FindBy(id = "index_email")
    private WebElement mailFld;

    @FindBy(id = "index_pass")
    private WebElement passFld;

    @FindBy(id = "index_login_button")
    public WebElement linkSignIn;

    @FindBy(id = "quick_forgot")
    public WebElement linkForgot;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(baseUrl);
    }

    public HomePage loginAs(UserData admin) {
        type(mailFld, admin.name);
        type(passFld, admin.pass);
        linkSignIn.click();
        return PageFactory.initElements(driver, HomePage.class);
    }


    public boolean isLoggedOut() {
        if (isElementPresent(linkForgot)){
            return true;
        }
        else {
            return false;
        }
    }
}
