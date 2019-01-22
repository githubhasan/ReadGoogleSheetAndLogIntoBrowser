package page.objects;
import base.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactUsPage extends BrowserDriver {

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Contact Us")
    private  WebElement pageTitle;
    public String contactUs(){
    String getText = pageTitle.getText();
    return getText;
    }
}
