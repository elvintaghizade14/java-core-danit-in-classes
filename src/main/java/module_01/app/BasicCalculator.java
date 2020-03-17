package module_01.app;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        // InputStream in = System.in;
        // Scanner scanner = new Scanner(in);
        Scanner input = new Scanner(System.in);

        //asking input for first number
        System.out.print("Please enter first number:   ");
        double first_num = input.nextDouble();

        //asking input for second number
        System.out.print("Please enter first number:   ");
        double second_num = input.nextDouble();

        //adding numbers and printing on console
        System.out.print("Sum of " + first_num + " and " + second_num + " is: " +
                (first_num + second_num));
    }
}
