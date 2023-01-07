package browserinvocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UxPinSignUp {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.uxpin.com/sign-up/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arun032315@gmail.com");
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Arun");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("199195");
        driver.findElement(By.xpath("/html/body/section/section/div[2]/div/form/button")).click();
    }
}
