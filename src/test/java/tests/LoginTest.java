package tests;

import base.BaseTest;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    Logger log = LogManager.getLogger(LoginTest.class);
    static {
        Configurator.setRootLevel(Level.INFO);
    }


    @Test
    public void positiveLoginTest(){
        LoginPage login = new LoginPage(driver);
        login.enterUsername("Admin");
        login.enterPassword("admin123");
        login.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        log.info("current URL after login" + currentUrl);

        Assert.assertTrue(currentUrl.contains("dashboard"),"login failed");
    }


}
