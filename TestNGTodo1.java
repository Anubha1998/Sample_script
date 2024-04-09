package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTodo1 {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "anubhas";
        String authkey = "V43usODamqIpEgmtJfXd5LFBkQOkJJrS1hL16A6vjwQQSTBHR4";
        ;
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Monterey");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", m.getName() + " - " + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("network", true);
        caps.setCapability("w3c", true);


        String[] Tags = new String[] { "Feature", "Falcon", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

    }

    @Test
    public void basicTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");

        driver.get("https://www.nike.com/in");
        Thread.sleep (1000);

        System.out.println("Checking sign in button");
       driver.findElement(By.xpath("//*[@id=\"hf_title_signin_membership\"]")).click();
        Thread.sleep (1000);
        System.out.println("Checking login Box");
        WebElement inputField= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        inputField.sendKeys("anubhas@lambdatest.com");
        Thread.sleep (1000);
        System.out.println("clicking on  continue");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/form/div/div[4]/button")).click();

        Thread.sleep (1000);


      //  driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 6");
      //  driver.findElement(By.id("addbutton")).click();

       // driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 7");
       // driver.findElement(By.id("addbutton")).click();

       // driver.findElement(By.id("sampletodotext")).sendKeys(" List Item 8");
      //  driver.findElement(By.id("addbutton")).click();

      //  System.out.println("Checking Another Box");
      //  driver.findElement(By.name("li1")).click();

      //  System.out.println("Checking Another Box");
       // driver.findElement(By.name("li3")).click();

       // System.out.println("Checking Another Box");
      //  driver.findElement(By.name("li7")).click();

      //  System.out.println("Checking Another Box");
       // driver.findElement(By.name("li8")).click();
      //  Thread.sleep(300);

       // System.out.println("Entering Text");
      //  driver.findElement(By.id("sampletodotext")).sendKeys("Get Taste of Lambda and Stick to It");

       // driver.findElement(By.id("addbutton")).click();

      //  System.out.println("Checking Another Box");
      //  driver.findElement(By.name("li9")).click();

        // Let's also assert that the todo we added is present in the list.

      //  spanText = driver.findElementByXPath("/html/body/div/div/div/ul/li[9]/span").getText();
      //  Assert.assertEquals("Get Taste of Lambda and Stick to It", spanText);
      //  Status = "passed";
     //   Thread.sleep(150);

        System.out.println("TestFinished");
        driver.quit();

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}