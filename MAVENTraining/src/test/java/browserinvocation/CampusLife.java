package browserinvocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampusLife {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver1.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.campuslife.co.in/contact.php");
        driver.findElement(By.xpath("//input[@name='uname']")).sendKeys("arun");
        driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("jhfbk");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hgjg@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Country Region']")).sendKeys("vhjk");
        driver.findElement(By.xpath("//textarea[@ng-model='msg']")).sendKeys("gffh bvjh btn");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form/div[6]/input")).click();
    }
}
