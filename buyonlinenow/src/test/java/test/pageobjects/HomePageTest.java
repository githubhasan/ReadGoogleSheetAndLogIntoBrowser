package test.pageobjects;

import base.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BrowserDriver {

    @Test
    public void SearchPageTest() {

        driver.findElement(By.id("search_text")).sendKeys("Laptop Sleeve", Keys.ENTER);
        String actualText = driver.findElement(By.partialLinkText("Kensington SP17 17\" Classic Laptop Sleeve")).getText();
        System.out.println("HomePage : Test Passed");

        Assert.assertEquals(actualText, "Kensington SP17 17\" Classic Laptop Sleeve");

    }
}

