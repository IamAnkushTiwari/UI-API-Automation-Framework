package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
    public static WebDriver driver;
    public static WebDriver getBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);
            return driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            return driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return driver = new FirefoxDriver();
        } else {
            return driver = new InternetExplorerDriver();
        }
    }

}
