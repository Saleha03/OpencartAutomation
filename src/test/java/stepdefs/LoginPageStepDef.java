package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageStepDef{

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

    }

    @After
    public void tearDown(){

            driver.quit();

    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
          driver.get("http://localhost/opencart/index.php?route=account/login&language=en-gb");
          loginPage=new LoginPage(driver);

    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {

            loginPage.setEmail("saleha03@gmail.com");
            loginPage.setPassword("test@123");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLogin();

    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(), true);

    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String string, String string2) {
        loginPage.setEmail(string);
        loginPage.setPassword(string2);

    }

    @Then("I should see error message indicating {string}")
    public void i_should_see_error_message_indicating(String string) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);

    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String string) {
        loginPage.clickForgottenPassword();

    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));

    }

}
