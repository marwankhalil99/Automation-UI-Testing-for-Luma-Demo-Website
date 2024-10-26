package Frameworks.AbstractComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AbstractComponent {
    protected WebDriver driver;
    protected WebDriverWait exWait;
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        exWait = new WebDriverWait(driver , Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }


}
