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
    private String Status = "passed";

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

        Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}
