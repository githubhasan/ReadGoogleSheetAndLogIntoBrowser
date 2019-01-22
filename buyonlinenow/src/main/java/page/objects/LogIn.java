package page.objects;

import application.page.base.ApplicationPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogIn extends ApplicationPageBase {


    private WebDriver driver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, partialLinkText = "Log In")
    private WebElement LogInBtn;

    @FindBy(how = How.ID, id = "username")
    private WebElement usernameBox;

    @FindBy(how = How.ID, id = "password")
    private WebElement pwBox;

    @FindBy(how = How.CLASS_NAME, className= "loginBtn")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, xpath = "//div[@id='tblLogin_intro']")
    private WebElement erroMessage;

    public LogIn login(String username, String password){

        sendKeys(usernameBox, "usernamebox", "email");
        sendKeys(pwBox, "pwBox", "password");
        click(submitButton,"submitButton");


        return new LogIn();
    }

    public String getErroMessage(){

        String actualText = getText(erroMessage,"erroMessage");

        return actualText;
    }
}
