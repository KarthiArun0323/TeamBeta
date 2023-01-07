package reusablebrowser;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LaunchBrowser {

    private static WebDriver driver;

    protected static WebDriver launchBrowser() throws IOException {

        String path = System.getProperty("user.dir");
        //System.out.println(path);

        FileInputStream file=new FileInputStream(new File(path + "/src/main/resources/utilities/utility.properties"));
        Properties properties = new Properties();
        properties.load(file);

        if(properties.getProperty("browser").equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver",path + "/src/main/resources/driver/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",path + "/src/main/resources/driver/chromedriver1.exe");
            driver = new ChromeDriver();
        }
        else{
            throw new InvalidArgumentException("please enter valid browser name:");
        }

        driver.navigate().to(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;

    }

    public static String name(){
        String value="Arun";
        return value; }

    public static int num(){
        int a=6;
        return a;
    }
}
