package Frameworks.TestCases;

import Frameworks.PageObject.HomePage;
import Frameworks.PageObject.MyAccount;
import Frameworks.PageObject.SignIn;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TC_SignIn extends BaseTest {
    @Test
    public void testLoginWithValidData() {
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(email, password);
        MyAccount myAccount = new MyAccount(driver);
        Assert.assertTrue(myAccount.validateSignInSuccess());
    }

    @Test(dataProvider = "getInvalidEmails")
    public void testLoginWithInvalidEmail(String invalidEmail){
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(invalidEmail, password);
        Assert.assertTrue(signIn.InvalidEmailErrorMessage());
    }
    @DataProvider(name="getInvalidEmails")
    public Object[] getInvalidEmails(){
        return new Object[]{"@domain.com ","user@domain"," "};
    }
    @Test
    public void testLoginWithInvalidPassword(){
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(email, "Test1234");
        Assert.assertTrue(signIn.InvalidPasswordErrorMessage());
    }

}
