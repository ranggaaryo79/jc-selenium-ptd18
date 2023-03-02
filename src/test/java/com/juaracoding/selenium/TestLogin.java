package com.juaracoding.selenium;

import com.juaracoding.selenium.drivers.DriverSingleton;
import com.juaracoding.selenium.pages.AddCartPage;
import com.juaracoding.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {
    public static WebDriver driver;
    public LoginPage login;
    public AddCartPage addCart;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        login = new LoginPage();
        addCart = new AddCartPage();
        driver.get("https://shop.demoqa.com/");
        login.Notice();
    }

    @Test(priority = 1)
    public void loginInValid() {
        login.login("ranggaaryo", "aaaaaaaaa");
        Assert.assertEquals(login.getTxtAccountIncorrect(),"ERROR: The username or password you entered is incorrect. Lost your password?");

    }

    @Test(priority = 2)
    public void loginValid() {
        delay(2);
        login.login("ranggaaryo","rangga123");
        Assert.assertEquals(login.getTxtDashboard(),"Dashboard");

    }
    @AfterClass
    public void quitBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long second) {
        System.out.println("Delay");
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
