package browserinvocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfotechFlexib {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver1.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.3i-infotech.com/aaa-flexib-campaign/");
        driver.findElement(By.xpath("//input[@placeholder='Name*']")).sendKeys("arun");
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("gwdjh");
        driver.findElement(By.xpath("//input[@placeholder='Designation*']")).sendKeys("hbjb");
        driver.findElement(By.xpath("//input[@placeholder='Email*']")).sendKeys("bcjck@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Contact Number*']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//input[@id='Submit']")).click();
    }
}
