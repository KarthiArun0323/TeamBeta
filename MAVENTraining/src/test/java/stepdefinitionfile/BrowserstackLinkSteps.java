package stepdefinitionfile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import reusablebrowser.LaunchBrowser;
import reusablemethods.Helper;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class BrowserstackLinkSteps extends LaunchBrowser{
    private WebDriver driver;
    private Helper driverHelper;

    @Given("user navigates to browserstack homepage")
    public void navigatesToBrowserstack() throws IOException {
       driver = LaunchBrowser.launchBrowser();
       driverHelper = Helper.instanceMethod(driver);
    }
    @Then("user validates the hyperlinks in the footer")
    public void validateshyperlinks() {
        WebElement footer = driver.findElement(By.id("footer-habitat"));
        int footerSize = footer.findElements(By.tagName("a")).size();
        System.out.println("The number of links in footer: " + footerSize);

        WebElement footerMenu = driver.findElement(By.xpath("//footer[@id='footer-habitat']/div/div"));
        int fHeadingSize = footerMenu.findElements(By.tagName("p")).size();
        System.out.println("The number of titles in footer: " + (fHeadingSize));

        System.out.println("The footer has titles as:");
        for (int j = 0; j < fHeadingSize ; j++) {
            String fHeadingList = footerMenu.findElements(By.tagName("p")).get(j).getText();
            System.out.println(fHeadingList);
        }

        WebElement company = driver.findElement(By.xpath("//div[@id='nav_menu-5']/ul"));
        int companySize = company.findElements(By.tagName("a")).size();
        System.out.println("The number of links under company is: " + companySize);
        System.out.println("The links under company are:");
        for (int i = 0; i < companySize; i++) {
            String companyList = company.findElements(By.tagName("a")).get(i).getText();
            System.out.println(companyList);
        }
    }
    @When("count links using set")
    public void countLinks() {
        int totallinks = driver.findElements(By.tagName("a")).size();
        System.out.println(totallinks);

        WebElement footer = driver.findElement(By.id("footer-habitat"));
        int footerLinks = footer.findElements(By.tagName("a")).size();
        System.out.println(footerLinks);

        List<WebElement> productLinks = footer.findElements(By.xpath("//div[@id='nav_menu-2']/ul/li/a"));
        for (WebElement links : productLinks) {
            links.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
        }

        Set<String> windowTitles=driver.getWindowHandles();
        for(String winproper:windowTitles){
            String title=driver.switchTo().window(winproper).getTitle();
            System.out.println(title);
        }
        driver.switchTo().defaultContent();
    }
}

