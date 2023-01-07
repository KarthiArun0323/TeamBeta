package conditionsofjava;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;
public class TnEb {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","F:\\Driver\\chromedriver1.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tnebnet.org/awp/login?l");
        System.out.println("enter username");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userName + Keys.ENTER);

        String actualErrorMessageLink=driver.findElement(By.xpath("//span[@title='Click here']")).getText();
        String ExpectedErrorMessageLink="Bad Credentials";

        if(actualErrorMessageLink.equals(ExpectedErrorMessageLink)) {
            System.out.println("Error Messages are equal");
        }
        else {
            System.out.println("Error Messages are Not equal");
        }
    }
}
