package conditionsofjava;
import org.openqa.selenium.InvalidArgumentException;
import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First Number:");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the Second Number:");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter the operator for calculation to be done:");
        String operator = scanner.next();
        int answer = 0;

        switch (operator) {
            case "+":
                answer = firstNumber + secondNumber;
                break;

            case "-":
                if (firstNumber > secondNumber) {
                    System.out.println(answer = firstNumber - secondNumber);
                } else {
                    System.out.println(answer = secondNumber - firstNumber);
                }
                break;

            case "/":

                switch ((firstNumber == 0) ? 0 :
                        (secondNumber == 0) ? 1 : 2) {
                    case 0:
                        System.out.println("enter the nonzero firstNumber:");
                        scanner = new Scanner(System.in);
                        firstNumber = scanner.nextInt();
                        answer = firstNumber / secondNumber;
                        break;
                    case 1:
                        System.out.println("enter the nonzero secondNumber:");
                        scanner = new Scanner(System.in);
                        secondNumber = scanner.nextInt();
                        answer = firstNumber / secondNumber;
                        break;
                    case 2:
                        answer = firstNumber / secondNumber;
                        break;
                    }

                break;

            case "*":
                answer = firstNumber * secondNumber;
                break;
            default:
                throw new InvalidArgumentException("Enter the valid Argument");
        }
        System.out.println(answer);
    }
}
