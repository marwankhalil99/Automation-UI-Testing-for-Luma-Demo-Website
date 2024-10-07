package Frameworks.TestCases;

import Frameworks.PageObject.Products;
import Frameworks.PageObject.SignIn;
import Frameworks.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_DeleteProduct extends BaseTest {
   @BeforeMethod
   public void loginAndToCart(){
       homePage.goToHomePage();
       Products product = new Products(driver);
       product.addToCart("Bruno Compete Hoodie", "Blue", "M");
       Assert.assertTrue(product.addToCartSuccessMessage("Bruno Compete Hoodie"));
       Assert.assertTrue(homePage.validateCartContent("Bruno Compete Hoodie"));
   }
    @Test
    public void clearCart() {
        homePage.deleteProducts();
        Assert.assertTrue(homePage.isCartEmpty());
    }
}
