package Frameworks.TestCases;

import Frameworks.PageObject.CreateAccount;
import Frameworks.PageObject.HomePage;
import Frameworks.PageObject.MyAccount;
import Frameworks.PageObject.SignOut;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_CreateAccount extends BaseTest {

    @Test
    public void createAccountWithValidData() {
        homePage.createAccountClick();
        CreateAccount createAccount = new CreateAccount(driver);
        MyAccount myAccount = createAccount.createAccount(fname, lname, email, password);
        Assert.assertTrue(myAccount.validateSuccessMessage());
    }

    @Test(dataProvider ="getInvalidEmails")
    public void createAccountWithInvalidEmailFormat(String emailTest) {
        homePage.createAccountClick();
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.createAccount(fname, lname, emailTest, password);
        Assert.assertTrue(createAccount.validateErrorMessage());
    }
    @DataProvider(name="getInvalidEmails")
    public Object[] getInvalidEmails(){
        return new Object[]{"@domain.com ","user.com","user@domain"," "};
    }
}
