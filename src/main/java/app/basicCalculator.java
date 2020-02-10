package app;

import java.util.Scanner;
import java.util.Formatter;

public class basicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter first number:   ");
        double first_num = input.nextDouble();

        System.out.print("Please enter first number:   ");
        double second_num = input.nextDouble();

        System.out.print("Sum of " + first_num + " and " + second_num + " is: " +
                (first_num + second_num));
    }
}
