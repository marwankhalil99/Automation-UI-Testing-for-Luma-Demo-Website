package Frameworks.TestComponents;

import Frameworks.PageObject.CreateAccount;
import Frameworks.PageObject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static String fname = "Test";
    public static String lname = "user";
    public static String email = "ussserrrrrrrerrssssssssssssssss@eexample.com";
    public static String password = "Test123@";
    public static String changedPassword = "Test123!";

    public WebDriver driver;
    public static HomePage homePage;
    public WebDriver initDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
    
    @BeforeClass
    public void lunchDriver(){
        driver = initDriver();
        homePage = new HomePage(driver);
        homePage.goToStartPoint();
    }
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

}
