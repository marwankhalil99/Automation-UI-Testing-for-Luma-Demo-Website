package Frameworks.TestCases;

import Frameworks.PageObject.*;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_E2EUserStory extends BaseTest
{
    @Test
    public void e2eTestWithSingleElementOnTheCart() {
        String fname = "test";
        String lname = "user";
        String email = "usserssteeeeessfsfssstt@domain.com";
        String password = "Test123!";
        homePage.createAccountClick();
        CreateAccount createAccount = new CreateAccount(driver);
        MyAccount myAccount = createAccount.createAccount(fname, lname, email, password);
        Assert.assertTrue(myAccount.validateSuccessMessage());
        homePage.goToHomePage();
        Products product = new Products(driver);
        product.addToCart("Bruno Compete Hoodie","Blue","M");
        Assert.assertTrue(product.addToCartSuccessMessage("Bruno Compete Hoodie"));
        Assert.assertTrue(homePage.validateCartContent("Bruno Compete Hoodie"));
        CheckOut_Shipping checkOutShipping = homePage.goToCheckOut();
        CheckOut_Review checkOutReview = checkOutShipping.setShoppingAddress(fname, lname, "123 Main St", "United States", "Palau", "Los Angeles", "90001", "1234567890", "Table Rate");
        SuccessPage successPage = checkOutReview.setPaymentMethod(0);
        Assert.assertTrue(successPage.validateSuccessMessage());
        System.out.println(successPage.getOrderId());
    }
}
