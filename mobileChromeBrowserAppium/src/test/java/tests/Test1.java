package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Test1 extends ChromeBase{

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver =  capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.hideKeyboard();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler")).click();
        driver.findElement(By.cssSelector("a[routerlink='/products']")).click();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)","");

        String devopsText = driver.findElement(By.xpath("//a[text()='Devops']")).getText();
        Assert.assertEquals(devopsText,"Devops");

        driver.findElement(By.xpath("//a[text()='Devops']")).click();

        String addToCartText = driver.findElement(By.xpath("//button[text()='Add to Cart']")).getText();
        Assert.assertEquals(addToCartText,"ADD TO CART");
        driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();

        String addedToCartText = driver.findElement(By.xpath("//button[text()='Added to Cart']")).getText();
        Assert.assertEquals(addedToCartText,"ADDED TO CART");

        if (driver != null){driver.quit();}
    }
}
