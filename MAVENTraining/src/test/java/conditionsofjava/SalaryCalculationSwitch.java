package conditionsofjava;
import org.openqa.selenium.InvalidArgumentException;
import java.util.Scanner;
public class SalaryCalculationSwitch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number Of Working Days value");
        int numberOfWorkingDays= scanner.nextInt();
        System.out.println("Enter Role");
        String Role = scanner.next();
        int salary=0;

        switch (Role.toLowerCase()) {
                case "manager":
                    salary = 900 * numberOfWorkingDays;
                    break;

                case "clerk":
                    salary = 600 * numberOfWorkingDays;
                    break;

                case "staff":
                    salary = 300 * numberOfWorkingDays;
                    break;
                    
                default:
                    throw new InvalidArgumentException("enter the valid Argument");
            }

        System.out.println(salary);
    }
}