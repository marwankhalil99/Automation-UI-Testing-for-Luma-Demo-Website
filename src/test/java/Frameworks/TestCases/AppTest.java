package Frameworks.TestCases;

import Frameworks.PageObject.*;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest extends BaseTest
{
    @Test
    public void createAccountWithValidData()
    {
        String fname = "test";
        String lname = "user";
        String email = "usersstest@domain.com";
        String password = "Test123!";
        MyAccount myAccount = createAccount.createAccount(fname, lname, email, password);
        Assert.assertTrue(myAccount.validateSuccessMessage());
        createAccount.goToHomePage();
        Products product = new Products(driver);
        product.addToCart("Bruno Compete Hoodie","Blue","M");
        Assert.assertTrue(product.addToCartSuccessMessage("Bruno Compete Hoodie"));
        Assert.assertTrue(product.validateCartContent("Bruno Compete Hoodie"));
        CheckOut_Shipping checkOutShipping = product.goToCheckOut();
        CheckOut_Review checkOutReview = checkOutShipping.setShoppingAddress(fname, lname, "123 Main St", "United States", "Palau", "Los Angeles", "90001", "1234567890", "Table Rate");
        SuccessPage successPage = checkOutReview.setPaymentMethod(0);
        Assert.assertTrue(successPage.validateSuccessMessage());
        System.out.println(successPage.getOrderId());


    }

}
