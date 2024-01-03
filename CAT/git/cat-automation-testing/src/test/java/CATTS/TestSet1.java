package CATTS;

import Base.CompetitorData;
import Base.Login;
import Base.Registeration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.swing.*;

public class TestSet1 {

    WebDriver driver;
    Login ls;
    Registeration rp;
    CompetitorData cd;

    @BeforeClass
    public void callBrowser(){
        driver = Base.Browser.getBrowser("edge");
    }

    @BeforeMethod
    public void callPage(){
        ls = new Login(driver);
        rp = new Registeration(driver);
        cd = new CompetitorData(driver);
    }

   @Test(priority = 1)
    public void ValidateURL(){
       ls.launchURL();
   }

   @Test(priority = 4)
   public void ValidateUserLogin() throws InterruptedException {ls.login("admin");}

   @Test(priority =5)
   public void CreateCompetitorData() throws InterruptedException {cd.createRec();}

    @Test(priority =6)
    public void UpdateCompetitorData() throws InterruptedException {cd.updateRec();}

    @Test(priority = 8)
    public void FilterCompetitorData() throws InterruptedException {
    cd.searchByUsername();
    }

    @Test(priority = 9)
    public void DownloadExcel(){
    cd.downloadEXCEL();
    }

    @Test(priority = 7)
    public void DeleteData()throws InterruptedException{
        cd.deleteData();
    }

    @Test(priority =9)
    public void Logout() throws InterruptedException{cd.Logout();}

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
