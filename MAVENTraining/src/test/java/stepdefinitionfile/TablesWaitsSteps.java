package stepdefinitionfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusablebrowser.LaunchBrowser;
import java.io.IOException;
import java.time.Duration;

public class TablesWaitsSteps extends LaunchBrowser{
    WebDriver driver;
        //cricbuzz
        int sum=0;

    @Given("user navigates to cricbuzz scorecard homepage")
    public void navigatesToCricbuzz() throws IOException {
        driver = LaunchBrowser.launchBrowser();
    }
    @When("user clicks on match and scorecard")
    public void clicksOnMatch(){
       // Actions actions = new Actions(driver);
       // WebElement targetMatch = driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 mrgn-btm-5']/nav/a[4]"));
       // actions.click(targetMatch).build().perform();
       // WebElement targetOption = driver.findElement(By.xpath("//div[@id='matchCenter']/div[2]/nav/a[2]"));
        //actions.click(targetOption).build().perform();
    }
    @Then("user iterates the values")
    public void iteratesValues(){
        WebElement inningsElement = driver.findElement(By.xpath("//div[@id='innings_1']"));
        int rowSize = inningsElement.findElements(By.xpath("//div[@id='innings_1']//div[1]//div[@class='cb-col cb-col-100 cb-scrd-itms']//div[@class='cb-col cb-col-8 text-right text-bold']")).size();
        System.out.println("The number players in innings are: "+rowSize);

        for(int i=0; i<rowSize; i++)
        {
            String runs =inningsElement.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']//div[@class='cb-col cb-col-8 text-right text-bold']")).get(i).getText();
            int totalRuns=Integer.parseInt(runs);
            sum = sum + totalRuns;
        }
        System.out.println("The total runs is: "+sum);
    }
    @And("user validates the totals are equal")
    public void validatesRun(){
        String totalValue = driver.findElement(By.xpath("//*[@id='innings_1']/div[1]/div[14]/div[2]")).getText();
        int actualTotal = Integer.parseInt(totalValue);
        System.out.println("The actual total is: "+actualTotal);

        String extrasValue = driver.findElement(By.xpath("//*[@id='innings_1']/div[1]/div[13]/div[2]")).getText();
        int extras = Integer.parseInt(extrasValue);
        System.out.println("The extras: "+extras);

        int expectedTotal = sum + extras;
        Assert.assertEquals(actualTotal,expectedTotal);
        System.out.println("The totals are equal");
    }

    //wikipedia
    @Given("user navigates to wikipedia page")
    public void navigatesToWikipedia() throws IOException {
        driver = LaunchBrowser.launchBrowser();

    }
    @Then("user validates the table")
    public void validatesTale(){
        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable mw-collapsible mw-made-collapsible']/tbody"));
        String tablerow = table.findElement(By.xpath("//tr[4]/th")).getText();
        System.out.println(tablerow + " for dec in madurai is:");
        String rowvalue = table.findElement(By.xpath("//tr[4]/td[12]")).getText();
        System.out.println(rowvalue);

        int columnSize = table.findElements(By.xpath("//tr[@style='text-align: center;']/th[@scope='row']")).size();
        System.out.println("The climate data for madurai, contains datas under "+columnSize+" different categories.They are,");
        for(int i=0; i<columnSize; i++){
            String column = table.findElements(By.xpath("//tr[@style='text-align: center;']/th[@scope='row']")).get(i).getText();
            System.out.println(column);
        }
    }
    @Given("user navigates to the demoqa homepage")
    public void navigatesToDemoqaHomepage() throws IOException {
        driver = LaunchBrowser.launchBrowser();
    }
    @Then("user validates the button should load only after 5sec")
    public void buttonLoadsAfter5sec() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("enableAfter")));
        //Thread.sleep(10);
        //driver.findElement(By.id("enableAfter"));
    }


}
