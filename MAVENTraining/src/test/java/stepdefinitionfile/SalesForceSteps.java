package stepdefinitionfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusablebrowser.LaunchBrowser;
import reusablemethods.Helper;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class SalesForceSteps extends LaunchBrowser {
    private WebDriver driver;
    private Helper driverHelper;

    @Given("User navigates to the login page")
    public void navigateToLoginPage() throws IOException {
        driver = LaunchBrowser.launchBrowser();
        driverHelper = Helper.instanceMethod(driver);
    }

    @When("User enter the username {string} and password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='pw']")).sendKeys(password);
    }

    @And("User clicks the login button")
    public void clickTheLoginButton() {
        driver.findElement(By.xpath("//input[@id='Login']")).click();
    }

    @Then("User should navigate to the homepage")
    public void navigateToHomepage() {
    }

    @Then("User should validate the error message")
    public void validateErrorMessage() {
        String actualErrorMessageLink = driver.findElement(By.xpath("//div[@id='error']")).getText();
        String ExpectedErrorMessageLink = "check your username and password. If you still can't log in, contact your Salesforce administrator.";

        if (actualErrorMessageLink.equals(ExpectedErrorMessageLink)) {
            System.out.println("Error Messages are equal");
        } else {
            System.out.println("Error Messages are Not equal");
        }
    }

    @When("user enter username and password")
    public void enterUsPw() {
        driverHelper.enterText(By.cssSelector(".input.r4.wide.mb16.mt8.username"), "Arun");

        //fluent wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

        driverHelper.enterText(By.xpath("//input[@id='password']"), "0323");
    }

    @And("clicks on login")
    public void clicksOnLogin() {
        driverHelper.clickElement(By.cssSelector(".button.r4.wide.primary"));
    }

    @Then("validates error")
    public void validatesError() {
        String actual = driverHelper.getTextValue(By.xpath("//div[@id='error']"));
        String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        Assert.assertEquals(actual, expected);
    }

}