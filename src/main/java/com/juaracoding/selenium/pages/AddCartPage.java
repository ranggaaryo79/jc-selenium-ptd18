package com.juaracoding.selenium.pages;

import com.juaracoding.selenium.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCartPage {
    WebDriver driver;

    public AddCartPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    WebElement homepage;
    @FindBy(xpath = "//a[contains(text(),'playboy x missguided plus size grey lips print fro')]")
    WebElement product;
    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement selectColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement selectSize;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div")
    WebElement notifySuccessAddCart;


    public String getNotifySuccessAddCart(){
        return notifySuccessAddCart.getText();
    }
    public void setAddToCart() {
        homepage.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        product.click();
        js.executeScript("window.scrollBy(0,500)");
        Select color = new Select(selectColor);
        color.selectByIndex(1);
        Select size = new Select(selectSize);
        size.selectByIndex(2);
        addToCart.click();

    }


}