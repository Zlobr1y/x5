package Task1;

import java.util.Scanner;

public class Calculator {

    Scanner in = new Scanner(System.in);
    float num1;
    float num2;
    float outcome;
    String action;
    Logger consoleLogger = new ConsoleLogger();
    Logger fileLogger = new FileLogger();
    Logger dbLogger = new DbLogger();

    public void startCalculator() {
        System.out.println("Введите первое число");
        num1 = in.nextInt();
        System.out.println("Введите второе число");
        num2 = in.nextInt();
        System.out.println("Выберете действие: / * + -");
        action = in.next();

        switch (action) {
            case "/":
                division();
                startCalculator();
            case "*":
                multiplication();
                startCalculator();
            case "+":
                addition();
                startCalculator();
            case "-":
                subtraction();
                startCalculator();
            default:
                System.out.println("Попробуйте еще раз");
                startCalculator();
        }
    }

    public void division() {
        outcome = num1 / num2;
        System.out.println(num1 + " / " + num2 + " = " + outcome);
        consoleLogger.log(String.valueOf(outcome));
        fileLogger.log(String.valueOf(outcome));
        dbLogger.log(String.valueOf(outcome));

    }

    public void multiplication() {
        outcome = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + outcome);
        consoleLogger.log(String.valueOf(outcome));
        fileLogger.log(String.valueOf(outcome));
        dbLogger.log(String.valueOf(outcome));
    }

    public void addition() {
        outcome = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + outcome);
        consoleLogger.log(String.valueOf(outcome));
        fileLogger.log(String.valueOf(outcome));
        dbLogger.log(String.valueOf(outcome));
    }

    public void subtraction() {
        outcome = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + outcome);
        consoleLogger.log(String.valueOf(outcome));
        fileLogger.log(String.valueOf(outcome));
        dbLogger.log(String.valueOf(outcome));
    }

}
