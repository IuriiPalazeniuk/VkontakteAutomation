/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BasicTestCase {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homepage;
    private String baseUrl = "http://vk.com/";

    @Test
    public void testLogin() throws Exception {

        loginPage.open();
        homepage = loginPage.loginAs(admin);
        Assert.assertTrue(homepage.isLoggedIn());
        Assert.assertEquals(baseUrl + "feed", driver.getCurrentUrl());
        LoginPage loginpage = homepage.logOut();
        Assert.assertTrue(loginpage.isLoggedOut());
        Assert.assertTrue(driver.getCurrentUrl().contains(baseUrl));

    }

}

