package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;


public class Utility {

    public static void xpath(){
        HashMap<String,String> xpaths = new HashMap<>();
        xpaths.put("","");
    }

    public static boolean isElementVisible(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }


    public static void dropdown(WebDriver driver, WebElement ele){

//       String [] str={"mantine-goxf1qtv6-1","mantine-goxf1qtv6-2","mantine-goxf1qtv6-3"};
//
//   String xpath="input[@aria-activedescendant='"+str[2]+"']";
//if(xpath.isDi){
//
//}
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.getElementById('mantine-goxf1qtv6').setAttribute('value', 'Iceman')");
//
////        Actions act = new Actions(driver);
////        isElementVisible(driver,ele);
////        act.moveToElement(ele).click().sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();


    }


    public static void send_Keys(WebDriver driver, WebElement ele,String input){
        Actions act = new Actions(driver);
        isElementVisible(driver,ele);
        act.moveToElement(ele).click();
        act.sendKeys(input).perform();
    }

    public static void update_Keys(WebDriver driver, WebElement ele,String input){
        Actions act = new Actions(driver);
        isElementVisible(driver,ele);
        act.moveToElement(ele).click();
        ele.clear();
        act.sendKeys(input).perform();
    }

    public static void send_doc(WebDriver driver, WebElement ele,String input){
        Actions act = new Actions(driver);
        isElementVisible(driver,ele);
        act.sendKeys(input).build().perform();
    }

    public static void click(WebDriver driver, WebElement ele){
        Actions act = new Actions(driver);
        isElementVisible(driver,ele);
        act.click(ele).build().perform();
    }

    public static String insertProperties(String data) {

        Properties p=new Properties();


        try{
            FileInputStream file  = new FileInputStream("Config.properties");

            p.load(file);

            file.close();

        }
        catch(Exception e){
            e.printStackTrace();
            e.fillInStackTrace();

        }

        return p.getProperty(data);
        }

        public String enterDetails(String input){
        return insertProperties(input);
        }



}
