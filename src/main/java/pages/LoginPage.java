package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath="//input[@id=\"input-email\"]")
    WebElement txtEmailAddress;

    @FindBy(xpath="//input[@id=\"input-password\"]")
    WebElement txtPassword;

    @FindBy(xpath="//button[contains(text(),\"Login\")]")
    WebElement btnLogin;

    @FindBy(xpath ="//div[@class=\"list-group mb-3\"]/child::a[contains(text(),'Forgotten Password')]" )
    WebElement forgottenPasswordlink;

    @FindBy(xpath="//div[@class=\"list-group mb-3\"]/child::a[contains(text(),'Logout')]")
    WebElement logoutLink;

    public void setEmail(String email) {
        txtEmailAddress.sendKeys(email);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void  clickForgottenPassword(){
        forgottenPasswordlink.click();
    }

    public boolean checkForgotPwdLink(){
        return forgottenPasswordlink.isDisplayed();
    }

    public boolean checkLogoutLink(){
        return logoutLink.isDisplayed();
    }

    public void login(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLogin();
    }

    public String getForgotPwdPageUrl(){
        String forgotpwdPageUrl= driver.getCurrentUrl();
        return forgotpwdPageUrl;
    }



    //div[@class="list-group mb-3"]/child::a[contains(text(),'Forgotten Password')]
}
