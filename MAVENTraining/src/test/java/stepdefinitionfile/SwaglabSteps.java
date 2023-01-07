package stepdefinitionfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusablebrowser.LaunchBrowser;
import java.io.IOException;

public class SwaglabSteps extends LaunchBrowser {
    WebDriver driver;
    @Given("User navigates to the swaglab login page")
    public void navigateToLoginPage() throws IOException {
        driver = LaunchBrowser.launchBrowser();
    }

    @When("User enter the swag username and password")
    public void enterUsernameAndPassword() {
        String a = driver.findElement(By.id("login_credentials")).getText();
        String USERNAME = a.substring(23, 37);
        String b = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String PASSWORD = b.substring(23, 36);
        System.out.println(USERNAME);
        System.out.println(PASSWORD);
        driver.findElement(By.id("user-name")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
    }
    @And("User clicks on the login button")
    public void clickTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should navigate to the swaglab homepage")
    public void navigateToSwagHomepage() {
    }

    @And("User gets the values from the dropdown")
    public void handleDropdown() {
        WebElement SortingElement = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
       // Select selectactive_option = new Select(ActiveoptionElement);
       // selectactive_option.selectByValue("lohi");

         int sortingDropdownSize = SortingElement.findElements(By.tagName("option")).size();

     for(int i=0; i<sortingDropdownSize ; i++)
     {
         String sortingValues = SortingElement.findElements(By.tagName("option")).get(i).getText();
         System.out.println(sortingValues);
     }
    }
}