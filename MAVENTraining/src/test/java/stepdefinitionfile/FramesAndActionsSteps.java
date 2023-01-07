package stepdefinitionfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import reusablebrowser.LaunchBrowser;
import java.io.IOException;

public class FramesAndActionsSteps extends LaunchBrowser{
    WebDriver driver;

@Given("user navigates to globalsqa homepage")
    public void navigateToGlobalsqaHomepage() throws IOException {
    driver= LaunchBrowser.launchBrowser();
}
@And("user extracts the mailid from homepage")
    public void extractsMailid(){

    WebElement frameElement = driver.findElement(By.name("globalSqa"));
    driver.switchTo().frame(frameElement);

    String actualMailId = driver.findElement(By.cssSelector("div[class='header_mail']")).getText();
    System.out.println("The mailid is : " + actualMailId);
    String expectedMailId = "contact@globalsqa.com";
    Assert.assertEquals(actualMailId,expectedMailId);
    System.out.println("It has been validated by assertion,that mailid contains @ and .");
    }


@Given("user navigates to yourstore homepage")
    public void navigatesToYourstore() throws IOException {
      driver= LaunchBrowser.launchBrowser();
    }
@When("user clicks on monitor after selecting components")
    public void clicksOnMonitor(){
    Actions action = new Actions(driver);
    WebElement target=driver.findElement(By.partialLinkText("Compo"));
    action.clickAndHold(target).build().perform();
    WebElement monitor=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/div/div/ul/li[2]"));
    action.click(monitor).build().perform();
    }
@And("user navigates to monitor page")
public void navigatesToMonitorPage(){
    WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div/div"));

    String actualText = title.findElement(By.xpath("//div[@class='col-sm-9']/h2")).getText();
    String expectedText = "Monitors";
    Assert.assertEquals(actualText,expectedText);
}
@Then("user extacts value and add it to 60")
    public void extractsValueAndAdd(){
WebElement monitorRate = driver.findElement(By.className("price-new"));
String monitorPrice = monitorRate.getText().substring(1,4);
int monitorValue = Integer.parseInt(monitorPrice);
        System.out.println("The extracted monitor value + 60 is =" +" $"+(monitorValue+60));
}


}
