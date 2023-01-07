package stepdefinitionfile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusablebrowser.LaunchBrowser;

import java.io.IOException;
import java.time.Duration;

public class AlertsSteps extends LaunchBrowser {
    private WebDriver driver;
    @Given("navigate to alert url")
    public void alertUrl() throws IOException {
        driver= LaunchBrowser.launchBrowser();
    }

    @When("clicks on button")
    public void clicksOnButton() {
        driver.findElement(By.id("alertButton")).click();
    }

    @Then("iterates the text value")
    public void iteratesTheTextValue() {
        String actualAlertText=driver.switchTo().alert().getText();
        String expectedAlertText="You clicked a button";
        Assert.assertEquals(actualAlertText,expectedAlertText);
        driver.switchTo().alert().accept();
    }

    @When("clicks on alert after 5sec button")
    public void after5sec() {
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    @Then("clicks on ok button")
    public void okButton() {
        String actualAlertText=driver.switchTo().alert().getText();
        String expectedAlertText="This alert appeared after 5 seconds";
        Assert.assertEquals(actualAlertText,expectedAlertText);
        driver.switchTo().alert().accept();
    }

    @When("validates confirm alert")
    public void confirmAlert() {
        driver.findElement(By.id("confirmButton")).click();
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "Do you confirm action?";
        Assert.assertEquals(actualAlertText, expectedAlertText);
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
    }

    @Then("validates confirm result")
    public void confirmResult(){
        String actualConfirm=driver.findElement(By.id("confirmResult")).getText();
        //String expectedConfirm="You selected Ok";
        String expectedConfirm="You selected Cancel";
        Assert.assertEquals(actualConfirm,expectedConfirm);
    }

    @When("validates prompt box")
    public void promptBox() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='javascriptAlertsWrapper']/div[4]/div[2]/button")));
        driver.findElement(By.xpath("//div[@id='javascriptAlertsWrapper']/div[4]/div[2]/button")).click();

        String actualAlertText=driver.switchTo().alert().getText();
        String expectedAlertText="Please enter your name";
        Assert.assertEquals(actualAlertText,expectedAlertText);

        driver.switchTo().alert().sendKeys("ArunKarthi");
        driver.switchTo().alert().accept();
    }

    @Then("validate prompt result")
    public void promptResult() {
        String actualPromptResult=driver.findElement(By.id("promptResult")).getText();
        String expectedPromptResult="You entered ArunKarthi";
        Assert.assertEquals(actualPromptResult,expectedPromptResult);
    }
}
