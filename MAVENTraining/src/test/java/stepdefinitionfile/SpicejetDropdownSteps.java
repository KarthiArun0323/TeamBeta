package stepdefinitionfile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import reusablebrowser.LaunchBrowser;
import reusablemethods.Methods;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SpicejetDropdownSteps extends LaunchBrowser{
    WebDriver driver;
    WebElement CurrencyElement;

    @Given("user navigates to spicejet homepage")
    public void navigatesToSpicejet() throws IOException {
        driver = LaunchBrowser.launchBrowser();
    }
    @When("user selects city in from dropdown")
    public void clicksOnFrom() throws InterruptedException {
        driver.findElement(By.name("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
        WebElement fromDropdown =driver.findElement(By.xpath("(//a[@value='BLR'])"));
        fromDropdown.click();
        Thread.sleep(500);
    }
    @Then("user selects city in to dropdown")
    public void navigatesToTo() throws InterruptedException {
        driver.findElement(By.name("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']//a[@value='MAA']")).click();
    }

    @When("user clicks on currency dropdown")
    public void clicksCurrencyDropdown() {
        CurrencyElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));
        Methods.selectDrop(CurrencyElement);
        //Select selectCurrency = new Select(CurrencyElement);
        //selectCurrency.selectByIndex(4);
        // selectCurrency.selectByVisibleText("USD");
        // selectCurrency.selectByValue("CAD");
    }

    @And("user gets the currency dropdown values")
    public void getsCurrencyValues() {
        int CurrencyDropdownSize = CurrencyElement.findElements(By.tagName("option")).size();
        for (int i = 0; i < CurrencyDropdownSize; i++) {
            String CurrencyValues = CurrencyElement.findElements(By.tagName("option")).get(i).getText();
            System.out.println(CurrencyValues);
        }
    }


    @When("user clicks dropdown beside the passenger")
    public void clicksDropdownBesidePassenger() {
        driver.findElement(By.xpath("//div[@class='row1 mobile-select-passengers']//div[@id='divpaxinfo']")).click();
    }

    @Then("user selects adults,child and infant values in the dropdown respectively")
    public void clickAdultChildAndInfantRespectively() {
        WebElement AdultElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT"));
        Select selectadult = new Select(AdultElement);
        selectadult.selectByIndex(5);

        WebElement ChildElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD"));
        Select selectchild = new Select(ChildElement);
        selectchild.selectByVisibleText("2");

        WebElement InfantElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_INFANT"));
        Select selectinfant = new Select(InfantElement);
        selectinfant.selectByValue("4");
    }


    @When("user clicks on current month date")
    public void clicksCurrentMonth(){
        driver.findElement(By.xpath("//div[@id='marketDate_1']//button[@class='ui-datepicker-trigger']")).click();
        while (!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']")).getText().contains("March"))
        {
            driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }
        WebElement departMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/child::table"));
        int monthSize = departMonth.findElements(By.xpath("//td[@data-handler='selectDay']")).size();
        for (int i = 0; i < monthSize; i++) {
            String neededDate = departMonth.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText();
            if (neededDate.equals("28")) {
                departMonth.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();
                break;
            }
        }
    }

    @Then("user clicks on april month date")
    public void clicksAprilDate() {
        driver.findElement(By.xpath("//div[@id='marketDate_2']//input[@class='custom_date_pic required home-date-input']")).click();
        while (!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']")).getText().contains("April"))
        {
            driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }
        WebElement returnMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/child::table"));
        int monthSize = returnMonth.findElements(By.xpath("//td[@data-handler='selectDay']")).size();
        for (int j = 0; j < monthSize; j++) {
            String neededDate = returnMonth.findElements(By.xpath("//td[@data-handler='selectDay']")).get(j).getText();
            if (neededDate.equals("6")) {
                returnMonth.findElements(By.xpath("//td[@data-handler='selectDay']")).get(j).click();
                break;
            }
        }
    }

    @When("iterates dropdown values using list")
    public void iteratesUsingList() {
        WebElement currencyElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));
        List<WebElement> dropdownValue = currencyElement.findElements(By.tagName("option"));
        ArrayList<String> currencies = new ArrayList<String>();
        for (WebElement Values : dropdownValue) {
            String currencyValue = Values.getText();
            currencies.add(currencyValue);
        }
        System.out.println(currencies);
    }
}
