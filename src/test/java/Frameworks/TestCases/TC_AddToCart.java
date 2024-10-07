package Frameworks.TestCases;

import Frameworks.PageObject.Products;
import Frameworks.PageObject.SignIn;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_AddToCart extends BaseTest {
    @BeforeMethod
    public void login() {
        homePage.signInClick();
        SignIn signIn = new SignIn(driver);
        signIn.signIn(email, password);
        homePage.goToHomePage();
    }

    @Test
    public void addToCart() {
        Products product = new Products(driver);
        product.addToCart("Bruno Compete Hoodie", "Blue", "M");
        Assert.assertTrue(product.addToCartSuccessMessage("Bruno Compete Hoodie"));
        Assert.assertTrue(homePage.validateCartContent("Bruno Compete Hoodie"));
    }
    @Test
    public void addToCart2Products() {
        Products product = new Products(driver);
        product.addToCart("Bruno Compete Hoodie","Blue","M");
        Assert.assertTrue(product.addToCartSuccessMessage("Bruno Compete Hoodie"));
        product.addToCart("Stark Fundamental Hoodie","Blue","M");
        Assert.assertTrue(product.addToCartSuccessMessage("Stark Fundamental Hoodie"));
        Assert.assertTrue(homePage.validateCartContent("Bruno Compete Hoodie"));
        Assert.assertTrue(homePage.validateCartContent("Stark Fundamental Hoodie"));
    }
}
