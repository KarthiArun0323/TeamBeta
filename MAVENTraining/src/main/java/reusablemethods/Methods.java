package reusablemethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Methods {

    public static void selectDrop(WebElement element){

        Select selectCurrency = new Select(element);
        //selectCurrency.selectByIndex(4);
         selectCurrency.selectByVisibleText("USD");
         //selectCurrency.selectByValue("CAD");
    }

    public static void selectRooms(WebElement element){
        Select roomsSelect=new Select(element);
        roomsSelect.selectByVisibleText("02");
    }
    public static void selectAdults(WebElement elem){
        Select adultsSelect=new Select(elem);
        adultsSelect.selectByValue("03");
    }
    public static void selectChildren(WebElement el){
        Select childrenSelect=new Select(el);
        childrenSelect.selectByIndex(3);
    }
}