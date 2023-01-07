package conditionsofjava;
import org.openqa.selenium.InvalidArgumentException;
import java.util.Scanner;
public class RangingNumbersSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number:");
        int number = scanner.nextInt();
        int answer = 0;

        switch ((number >= 1 && number <= 10) ? 0 :
               (number >= 11 && number <= 20) ? 1 :
               (number >= 21 && number <= 50) ? 2 :
               (number >= 51 && number <= 100) ? 3 : 4) {

            case 0:
                answer = number * 2;
                break ;
            case 1:
                answer = number * 3 ;
                break ;
            case 2:
                answer = number * 4 ;
                break ;
            case 3:
                answer = number * 5 ;
                break ;
            case 4:
                throw new InvalidArgumentException("Enter the number");
        }
        System.out.println(answer);
    }
}


