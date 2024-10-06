package Frameworks.TestCases;

import Frameworks.PageObject.MyAccount;
import Frameworks.PageObject.SignIn;
import Frameworks.PageObject.SignOut;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_SignOut extends BaseTest {
    @BeforeMethod
    public void signIn(){
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(email, password);
    }
    @Test
    public void testSignOut() {
        SignOut signOut = new SignOut(driver);
        signOut.signOut();
        MyAccount myAccount = new MyAccount(driver);
        Assert.assertTrue(myAccount.validateSignOutSuccess());
    }
}
