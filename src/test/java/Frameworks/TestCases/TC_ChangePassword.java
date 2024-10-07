package Frameworks.TestCases;

import Frameworks.PageObject.ChangePassword;
import Frameworks.PageObject.MyAccount;
import Frameworks.PageObject.SignIn;
import Frameworks.PageObject.SignOut;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class TC_ChangePassword extends BaseTest {
    @BeforeMethod
    public void login(){
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(email, password);
        MyAccount myAccount = new MyAccount(driver);
        Assert.assertTrue(myAccount.validateSignInSuccess());
    }
    @Test
    public void changePassword()  {
        SignIn signIn = new SignIn(driver);
        homePage.goToMyAccount();
        MyAccount myAccount = new MyAccount(driver);
        myAccount.changePasswordClick();
        ChangePassword changePassword = new ChangePassword(driver);
        changePassword.changePassword(password, changedPassword);
        Assert.assertTrue(signIn.ChangePasswordSuccessMessage());
        changePassword.reSignIn(email,changedPassword);
        Assert.assertTrue(myAccount.validateSignInSuccess());
    }
    @AfterMethod
    public void logout() throws InterruptedException {

        MyAccount myAccount = new MyAccount(driver);
        SignOut signOut1 = new SignOut(driver);
        signOut1.signOut();
        Assert.assertTrue(myAccount.validateSignOutSuccess());
    }
}
