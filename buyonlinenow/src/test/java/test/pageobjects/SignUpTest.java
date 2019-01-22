package test.pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.SignUp;


public class SignUpTest extends SignUp {


    SignUp objOfSignUp = null;


    @BeforeMethod
    public void initializationOfElements() {

        objOfSignUp = PageFactory.initElements(driver, SignUp.class);
    }

    @Test(priority = 3)
    public void SignUpPageTest() throws InterruptedException {
        objOfSignUp.SignUp();
        System.out.println("SignUpPage : Test Passed");
    }

}

