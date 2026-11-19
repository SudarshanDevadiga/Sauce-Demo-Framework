package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    private static Logger logger =
            LogManager.getLogger(
                    LoginTest.class);

    @Test
    public void verifyValidLogin() {

        logger.info("Launching browser");

        InventoryPage inventoryPage =
                new LoginPage(driver)
                        .login(
                                "standard_user",
                                "secret_sauce");

        Assert.assertTrue(
                inventoryPage.isLoaded(),
                "Inventory Page did not load");

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products");

        logger.info("Login successful");
    }
}
