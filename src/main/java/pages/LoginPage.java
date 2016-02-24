package pages;

import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class LoginPage extends Page {

    @FindBy(id = "quick_email")
    private WebElement mailFld;

    @FindBy(id = "quick_pass")
    private WebElement passFld;

    @FindBy(id = "quick_login_button")
    public WebElement linkSignIn;

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
        if (isElementPresent(linkSignIn)){
            return true;
        }
        else {
            return false;
        }
    }
}
