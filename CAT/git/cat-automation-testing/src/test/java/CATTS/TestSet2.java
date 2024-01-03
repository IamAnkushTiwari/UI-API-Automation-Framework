package CATTS;

import Base.CompetitorData;
import Base.Login;
import Base.Registeration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSet2 {

    WebDriver driver;

    Login ls;

    @BeforeClass
    public void callBrowser(){
        driver = Base.Browser.getBrowser("chrome");
    }

    @BeforeMethod
    public void callPage(){
        ls = new Login(driver);
    }

    @Test(priority = 1)
    public void ValidateURL(){
        ls.launchURL();
    }

    @Test(priority = 4)
    public void ValidateUserLogin() throws InterruptedException {ls.login("user");}

}
