package reusablemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {

    private WebDriver webDriver;

    private Helper(WebDriver driver){
        webDriver=driver;
    }
    public static Helper instanceMethod(WebDriver driver){
        Helper driverHelper=new Helper(driver);
        return driverHelper;
    }

    public void enterText(By locator, String textValue){
        webDriver.findElement(locator).sendKeys(textValue);
    }

    public void clickElement(By locator){
        webDriver.findElement(locator).click();
    }

    public String getTextValue(By locator){
       String textValue= webDriver.findElement(locator).getText();
       return textValue;
    }
}
