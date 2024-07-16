package StepDefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {
    Page page;
    @Given("navigate to login page of Saucelabs")
    public void navigate_home(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @Then("sauce labs logo is present on screen")
    public void logoverification(){

        if(page.locator("//*[@class='login_logo']").isVisible())
            System.out.println("Logo is visible");
    }
    @Then("Username inputbox is visible")
    public void ussernamevisibility(){
        if(page.locator("//*[@data-test='username']").isVisible())
            System.out.println("Username is visible");
    }
    @Then("Password inputbox is visible")
    public void passwordvisibility(){
        if(page.locator("//*[@data-test='username']").isVisible())
            System.out.println("Password is visible");
    }
    @Then("Login button is visible")
    public void loginbuttonvisibility(){
        if(page.locator("//*[@data-test='username']").isVisible())
            System.out.println("Login button is visible");
    }
    @Given("Enter the username as {string}")
    public void enterusername(String username){
        page.locator("//*[@data-test='username']").fill(username);

    }
    @Given("Entre the Password as {string}")
    public void entre_the_password_as(String password) {
        page.locator("//*[@data-test='password']").fill(password);
    }
    @When("Click on Login button")
    public void click_on_login_button() {
        page.locator("//*[@data-test='login-button']").click();
    }
    @Then("Login is as {string}")
    public void login_is_as(String Message) {
        if(page.locator("//*[@data-test='title']").isVisible())
            System.out.println(Message);
        else if(page.textContent("//*[@data-test='error']").equals(Message))
        System.out.println(page.textContent("//*[@data-test='error']"));
    }

}
