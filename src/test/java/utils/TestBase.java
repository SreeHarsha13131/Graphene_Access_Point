package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public TestBase DriverManager;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//resources//global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String url = properties.getProperty("Testurl");
//        String userName = properties.getProperty("UserName");
//        String password = properties.getProperty("Password");
        if (driver == null) {
            if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.getProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "//src/test//resource//chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);
        }
        return driver;

    }

}
