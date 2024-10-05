package Frameworks.TestCases;

import Frameworks.PageObject.MyAccount;
import Frameworks.TestComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CreateAccount extends BaseTest {
    @Test
    public void createAccountWithValidData() {
        String fname = "test";
        String lname = "user";
        String email = "uusersssssssteessssssstt@domain.com";
        String password = "Test123!";
        MyAccount myAccount = createAccount.createAccount(fname, lname, email, password);
        Assert.assertTrue(myAccount.validateSuccessMessage());
    }

    @Test
    public void createAccountWithInvalidEmailFormat() {

    }
}
