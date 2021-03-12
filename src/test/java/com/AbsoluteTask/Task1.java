package com.AbsoluteTask;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Task1 {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    /*
Steps
    1. Launch a web browser to go to http://www.uitestingplayground.com/clientdelay
    2. Click the button “Button Triggering Client Side Logic”
    3. A loading icon will be shown on the right of the button
    4. A textbox with green background will be shown
    5. Verify the text on the textbox – “Data calculated on the client side.”

     */



    @Test
    public  void Scenario() throws InterruptedException {
      driver.get("http://www.uitestingplayground.com/clientdelay");
      driver.findElement(By.id("ajaxButton")).click();


        String actualResult=driver.findElement(By.xpath("//p[@class='bg-success']")).getText();
        String expectedResult="Data calculated on the client side.";
        Assert.assertEquals(actualResult,expectedResult);


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
