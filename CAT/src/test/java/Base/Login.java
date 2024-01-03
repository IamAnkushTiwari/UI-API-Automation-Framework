package Base;


import Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

//import static Base.Registeration.email;


public class Login extends Utility {

    WebDriver driver;
    public Login(WebDriver driver){
      this.driver = driver;
      PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[text()='  Register']")private WebElement clickRegister;

    @FindBy(xpath="//input[@id='username']")private WebElement login;

    @FindBy(xpath = "//input[@id='password']")private  WebElement password;

    //button[@type='submit']
    @FindBy(xpath = "//input[@id='kc-login']")private  WebElement Login;

    public void launchURL(){
        driver.get(enterDetails("TEUrl"));
        driver.manage().window().maximize();
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void redirectRegister(){
     //   isElementVisible(driver,clickRegister);
        clickRegister.click();
    }

    public void login(String access) throws InterruptedException {

        if(access.equalsIgnoreCase("user")){
        Thread.sleep(2000);
        login.sendKeys(enterDetails("UN"));
        password.sendKeys(enterDetails("UP"));
        Login.click();}
        else if(access.equalsIgnoreCase("admin")){
        Thread.sleep(2000);
        login.sendKeys(enterDetails("AN"));
        password.sendKeys(enterDetails("AP"));
        Login.click();}
        else{
            Thread.sleep(2000);
            login.sendKeys(enterDetails("Adminname"));
            password.sendKeys(enterDetails("AdminPassword"));
            Login.click();
        }
    }

    public void Adminlogin() throws InterruptedException {
        Thread.sleep(2000);
        login.sendKeys(enterDetails("TEUsername"));
        password.sendKeys(enterDetails("TEPassword"));
        Login.click();
    }

}
