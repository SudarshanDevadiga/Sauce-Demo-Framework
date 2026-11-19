package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class CheckoutTest
        extends BaseTest {

    @Test
    public void verifyCheckoutFlow() {

        InventoryPage inventoryPage =
                new LoginPage(driver)
                        .login(
                                "standard_user",
                                "secret_sauce");

        Assert.assertTrue(
                inventoryPage.isLoaded());

        inventoryPage.addBackpackToCart();

        CartPage cartPage =
                inventoryPage.goToCart();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("cart"));

        CheckoutPage checkoutPage =
                cartPage.clickCheckout();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("checkout-step-one"));

        checkoutPage.enterCustomerDetails(
                "Muskaan",
                "Gulrajani",
                "400706");
    }
}
