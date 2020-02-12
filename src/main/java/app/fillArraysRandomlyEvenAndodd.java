package app;

import java.util.Arrays;

public class fillArraysRandomlyEvenAndodd {

    public static void main(String[] args) {

        int random_num;
        int tmp;

        int[] even_arr = new int[30];
        int[] odd_arr = new int[30];

        int sum_even = 0;
        int sum_odd = 0;

        for (int i = 0; i < 30; i++) {

            while (true) {
                random_num = (int) (Math.random() * 41 - 20);

                tmp = random_num;

                if (random_num < 0) {
                    random_num = -1 * random_num;
                }

                if ((random_num % 2) == 0) {
                    even_arr[i] = tmp;
                    sum_even += tmp;
                    break;
                }
            }

            while (true) {
                random_num = (int) (Math.random() * 61 - 30);

                tmp = random_num;

                if (random_num < 0) {
                    random_num = -1 * random_num;
                }

                if ((random_num % 2) == 1) {
                    odd_arr[i] = tmp;
                    sum_odd += tmp;
                    break;
                }
            }

        }

        System.out.println("Sum of both is: " + (sum_even + sum_odd));
        System.out.println("Sum of elements of even arr: " + sum_even + "\nElements:");
        System.out.print(Arrays.toString(even_arr));
        System.out.println();
        System.out.println("Sum of elements of odd arr: " + sum_odd + "\nElements:");
        System.out.print(Arrays.toString(odd_arr));
        System.out.println();

    }
}
