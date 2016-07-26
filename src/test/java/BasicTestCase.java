import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import data.UserData;

/**
 * Created by Maksym_Mazurkevych on 2/24/2016.
 */
public class BasicTestCase {

    protected static WebDriver driver;

    public UserData admin = new UserData("email.com", "pass");

    protected  WebDriver getWebDriver(){
        if (driver == null){
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}
