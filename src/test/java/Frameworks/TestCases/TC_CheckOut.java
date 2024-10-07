package Frameworks.TestCases;

import Frameworks.PageObject.CheckOut_Review;
import Frameworks.PageObject.CheckOut_Shipping;
import Frameworks.PageObject.SignIn;
import Frameworks.PageObject.SuccessPage;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_CheckOut extends BaseTest {
    @BeforeMethod
    public void login() {
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(email, password);
        homePage.goToHomePage();
    }
    @Test
    public void testCheckOut() {
        CheckOut_Shipping checkOutShipping = homePage.goToCheckOut();
        CheckOut_Review checkOutReview = checkOutShipping.setShoppingAddress(fname, lname, "123 Main St", "United States", "Palau", "Los Angeles", "90001", "1234567890", "Table Rate");
        SuccessPage successPage = checkOutReview.setPaymentMethod(0);
        Assert.assertTrue(successPage.validateSuccessMessage());
        System.out.println(successPage.getOrderId());
    }
}
