package Base;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registeration {


    WebDriver driver;

    Faker fake;
//    static public String pass;
//    static public String email;

    public Registeration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        fake = new Faker();
    }

    @FindBy(xpath = "//input[@placeholder='Your First name']")private WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Your Last name']")private WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Your Username']")private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Your Email']")private WebElement emails;

    @FindBy(xpath = "//input[@placeholder='Your Password']")private WebElement password;

    @FindBy(xpath = "//input[@placeholder='Your Confirm Password']")private WebElement confirmpass;

    @FindBy(xpath = "//button[@type='submit']")private WebElement Register;

    public void sendRegData()
    {
        firstname.sendKeys(fake.name().firstName());
        lastname.sendKeys(fake.name().lastName());
        String email = fake.internet().emailAddress();
        username.sendKeys(email);
        emails.sendKeys(email);
        String pass = fake.internet().password();
        password.sendKeys(pass);
        confirmpass.sendKeys(pass);
        Register.click();
    }

}
