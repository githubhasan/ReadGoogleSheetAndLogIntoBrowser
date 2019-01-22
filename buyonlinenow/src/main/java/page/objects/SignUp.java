package page.objects;

import base.BrowserDriver;
import org.openqa.selenium.By;


public class SignUp extends BrowserDriver {

    public void SignUp() throws InterruptedException {

        driver.findElement(By.partialLinkText("Create Account")).click();

        driver.findElement(By.id("FirstNameBilling")).sendKeys("Md");
        Thread.sleep(500);
        driver.findElement(By.id("LastNameBilling")).sendKeys("Hasan");
        Thread.sleep(500);

        driver.findElement(By.id("Username2")).sendKeys("vala_nai@yahoo.com");
        Thread.sleep(500);
        driver.findElement(By.id("Password1")).sendKeys("Test@1234");
        Thread.sleep(500);
        driver.findElement(By.id("Password2")).sendKeys("Test@1234");
        Thread.sleep(500);

        driver.findElement(By.className("ccBtnSubmit")).click();


    }

}
