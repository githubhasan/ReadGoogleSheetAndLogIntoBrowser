package page.objects;

import application.page.base.ApplicationPageBase;
import base.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BrowserDriver {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "search_text")
    private WebElement searchBox;

    @FindBy(how = How.CLASS_NAME, className = "SubmitLogin")
    private WebElement submitButton;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Log In")
    private WebElement LogInBtn;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Contact Us")
    private WebElement contactUs;


    public LogIn getLogIn() {
        LogInBtn.click();
        return new LogIn();
    }


    public LogIn clickContactUs() {

        ApplicationPageBase.isEnableStatus(driver, contactUs);
        contactUs.click();
        return new LogIn();
    }
}























/*public HomePage() {
      // BrowserDriver.getUrl());
       // this.driver=BrowserDriver.getDriver();
        PageFactory.initElements(driver, this);
    }
*/