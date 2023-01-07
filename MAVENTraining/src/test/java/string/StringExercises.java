package string;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringExercises {
    public static void main(String[] args) {

        String ak = "Learnmore";
        System.out.println("The word 'Learnmore' has the letter 'm':  " + (ak . contains("m")));

        String sample = "246";
        int num1 = 27;
        int num2 = Integer.parseInt(sample);
        System.out.println("converting string '246' and add with integer '27': "+ (num1 + num2));

        String number = "27.22";
        double floatnumber = 2.5;
        Float floatvalue = Float.parseFloat(number);
        System.out.println("converting float number '27.22' and add with '2.7': "+ (floatvalue+floatnumber));

        System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/app.html");
        String message=driver.findElement(By.xpath("//h6[@id='time']")).getText();
        String value=(message.substring(31,37));
        System.out.println("The extracted value from message is:      "+value);

        String totalbalance=driver.findElement(By.xpath("//div[@class='balance hidden-mobile']//div[@class='balance-value']")).getText();
        String firstnumber=totalbalance.substring(1,4);
        System.out.println("The total balance is:  " + firstnumber);

        String creditavailable=driver.findElement(By.xpath("//div[@class='balance']//div[@class='balance-value']")).getText();
        String secondnumber=((creditavailable.substring(1,3))+(creditavailable.substring(4,7)));
        System.out.println("The credit available is:  " + secondnumber);

        String duetoday=driver.findElement(By.xpath("//div[@class='balance-value danger']")).getText();
        String thirdnumber=(duetoday.substring(1,4));
        System.out.println("The due today is:  " + thirdnumber);

        int sum= Integer.parseInt(firstnumber) + Integer.parseInt(secondnumber) + Integer.parseInt(thirdnumber);
        System.out.println("The sum of extracted values is:    "+sum);
            }
}
