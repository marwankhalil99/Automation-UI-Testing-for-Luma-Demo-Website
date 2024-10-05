package Frameworks.TestComponents;

import Frameworks.PageObject.CreateAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public CreateAccount createAccount;
    public WebDriver initDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
    @BeforeMethod
    public void lunchDriver(){
        driver = initDriver();
        createAccount = new CreateAccount(driver);
        createAccount.goTo();
    }
//    @AfterMethod
//    public void quitDriver(){
//        driver.quit();
//    }
}
