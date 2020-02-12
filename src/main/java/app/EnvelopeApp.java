package app;

import java.util.Scanner;

public class EnvelopeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();

        for (int i = 0; i < height; i++) {
            if ((i == 0) || (i == (height - 1))) {
                for (int j = 0; j < width; j++) {
                    System.out.print('*');
                }
                System.out.println();
            } else {
                for (int j = 0; j < width; j++) {
                    if((j==0) || (j==(width-1))){
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }
}
