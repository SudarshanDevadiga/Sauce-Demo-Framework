package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class NegativeLoginTest
        extends BaseTest {

    @Test
    public void verifyInvalidLogin() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.loginWithInvalidUser(
                "wrongUser",
                "wrongPassword");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");

        Assert.assertFalse(
                driver.getCurrentUrl()
                        .contains("inventory"));
    }
}
