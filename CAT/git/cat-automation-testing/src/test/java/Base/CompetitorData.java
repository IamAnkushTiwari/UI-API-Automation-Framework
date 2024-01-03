package Base;

import Utility.Utility;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.geom.Area;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CompetitorData extends Utility {

    WebDriver driver;
    Faker fake;

    public String fullname;

    public CompetitorData(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        fake = new Faker();
    }

        @FindBy(xpath="//span[normalize-space()='Create Record']")private WebElement clickRecordButton;
        @FindBy(xpath = "(//label[text()='Team']/following::div)[1]")private WebElement team;
        @FindBy(xpath = "(//label[text()='Department']/following::div)[1]")private WebElement Department;
        @FindBy(xpath = "(//label[text()='Sub Department']/following::div)[1]")private WebElement SubDepartment;
        @FindBy(xpath = "(//label[text()='Department Module']/following::div)[1]")private WebElement DepartmentModule;
        @FindBy(xpath = "(//label[text()='Contact Person']/following::div)[1]")private WebElement contactperson;
        @FindBy(xpath = "(//label[text()='Area']/following::div)[1]")private WebElement area;
        @FindBy(xpath = "(//label[text()='Status']/following::div)[1]")private WebElement status;
        @FindBy(xpath = "(//label[text()='Competitor Details']/following::div)[1]")private WebElement compitetordetails;
        @FindBy(xpath = "(//label[text()=\"No of FTE's\"]/following::div)[1]")private WebElement nooffte;
        @FindBy(xpath = "(//label[text()='Documentation in Confluence']/following::div)[1]")private WebElement documentation;
        @FindBy(xpath = "(//label[text()='Technical Team']/following::div)[1]")private WebElement technicalteam;
        @FindBy(xpath = "(//label[text()='Technical Role']/following::div)[1]")private WebElement technicalrole;
        @FindBy(xpath = "(//label[text()='Features/Activities']/following::div)[1]")private WebElement featureactivities;
        @FindBy(xpath = "(//label[text()='Technology Stack']/following::div)[1]")private WebElement technologyStack;
        @FindBy(xpath = "(//label[text()='Region']/following::div)[1]")private WebElement region;
        @FindBy(xpath = "(//label[text()='Brand']/following::div)[1]")private WebElement brand;
        @FindBy(xpath = "(//label[text()='Systems']/following::div)[1]")private WebElement systems;
        @FindBy(xpath = "(//label[text()='Activities']/following::div)[1]")private WebElement activities;
        @FindBy(xpath = "(//label[text()='Strength of Current Supplier']/following::div)[1]")private WebElement strength;
        @FindBy(xpath = "(//label[text()='Weakness of Current Supplier']/following::div)[1]")private WebElement weakness;
        @FindBy(xpath = "(//label[text()='Remarks']/following::div)[1]")private WebElement remarks;

     //   @FindBy(xpath = "(//*[local-name()='svg'])[72]")private WebElement upload;

        //span[text()='Create']

        @FindBy(xpath = "//span[text()='Update']")private WebElement update1;

        @FindBy(xpath = "//span[text()='Create']")private WebElement create;

    @FindBy(xpath= "(//td[@class='mantine-1br37mo']//div//button)[5]")private WebElement update;

    @FindBy(xpath= "//span[@class='mantine-Button-icon mantine-Button-rightIcon mantine-1szhp1h']")private WebElement username;

    @FindBy(xpath = "(//button[@role='menuitem'])[2]")private WebElement logout;

    @FindBy(xpath = "(//button[@class='mantine-UnstyledButton-root mantine-ActionIcon-root mantine-asm909'])[1]") private WebElement search;

    @FindBy(xpath ="(//tr[@class='mantine-2kfh7k']//td)[5]")private WebElement validatename;

    //span[text()='Download EXCEL']

    @FindBy(xpath = "//span[text()='Download Excel']")private WebElement downlaodExcel;

    @FindBy(xpath = "//input[@placeholder='Search']")private WebElement getSearch;

    @FindBy(xpath= "(//*[local-name()='svg'and @stroke-width='2'])[60]")private WebElement delete;

    @FindBy(xpath = "//span[text()='Delete']")private WebElement delpopup;

    public boolean isElementVisible( WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

        public void handleDropdown(WebElement xpath){
            Actions act = new Actions(driver);
            isElementVisible(xpath);
            act.moveToElement(xpath).click().sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        }

    public void send_Keys(WebElement xpath, String input){
        Actions act = new Actions(driver);
        isElementVisible(xpath);
        act.moveToElement(xpath).click().sendKeys(input).build().perform();
    }


    public void createRec()
    {

        try {Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Page has loaded");
        }
        driver.findElement(By.xpath("//*[text()='Create Record']")).click();
        WebElement ar[] = {team,Department,SubDepartment,DepartmentModule,area,status,compitetordetails,technicalteam,technicalrole,region,brand,systems};
        for(int i = 0 ; i<=ar.length-1 ; i++) {
            handleDropdown(ar[i]);
        }

        send_Keys(contactperson,fake.name().fullName());
        create.click();}
        catch(Exception e){
            Exception exception;
        }
    }

    public void updateRec()
    {

        try {Thread.sleep(5000);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            JavascriptExecutor j = (JavascriptExecutor)driver;
            if (j.executeScript("return document.readyState").toString().equals("complete")){
                System.out.println("Page has loaded");
            }
            driver.findElement(By.xpath("(//td[@class='mantine-1br37mo']//div//button)[5]")).click();
            WebElement ar[] = {team,Department,SubDepartment,DepartmentModule,area,status,compitetordetails,technicalteam,technicalrole,region,brand,systems};
            for(int i = 0 ; i<=ar.length-1 ; i++) {
                handleDropdown(ar[i]);
            }
            send_Keys(contactperson,fake.name().fullName());
           update1.click();}
        catch(Exception e){
            Exception exception;
        }
    }

    public void update() throws InterruptedException {
        Thread.sleep(5000);
        update.click();
        handleDropdown(team);
        handleDropdown(SubDepartment);
        handleDropdown(DepartmentModule);
        send_Keys(contactperson,fake.name().fullName());
        handleDropdown(area);
        handleDropdown(status);
        handleDropdown(compitetordetails);
        send_Keys(driver,nooffte,fake.number().digit());
        send_Keys(documentation,"www.confluence.com");
        handleDropdown(technicalteam);
        handleDropdown(technicalrole);
        handleDropdown(region);
        handleDropdown(brand);
        send_Keys(driver,systems,",MAC-OS");
        send_Keys(driver,activities,", SPECTRE");
        dropdown(driver,compitetordetails);


        update1.click();
    }

    public void Logout() throws InterruptedException {
        Thread.sleep(2000);
        click(driver,username);
        click(driver,logout);
    }

    public void searchByUsername()throws InterruptedException {
        Thread.sleep(3000);
        click(driver,search);
        send_Keys(driver,getSearch,"Cooper");
      //  Assert.assertEquals(fullname,validatename.getText());
    }

    public void downloadEXCEL(){downlaodExcel.click();}

    public void deleteData() throws InterruptedException {
        Thread.sleep(3000);
        delete.click();
        delpopup.click();
    }
}
