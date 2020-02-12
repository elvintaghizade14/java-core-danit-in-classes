package app;

import java.util.Arrays;

public class PositiveAndNegativeInRandomArrayApp {
    public static void main(String[] args) {
        final int LEN = 30;
        // 1. generation of random numbers / filling
        int[] base = new int[LEN];

        int pos_indx = 0;
        int neg_indx = 0;

        for (int i = 0; i < base.length; i++) {
            int r = (int) (Math.random() * 201 - 100);
            base[i] = (r == 0) ? (r + 1) : r;

            if (base[i] > 0)
                pos_indx++;
            else if (base[i] < 0)
                neg_indx++;
        }
        // operations
        int[] positive = new int[pos_indx];
        int[] negative = new int[neg_indx];

        for (int value : base) {
            if (value > 0) {
                positive[positive.length-pos_indx--] = value;

            } else {
                negative[negative.length-neg_indx--] = value;
            }
        }
        // 3. printing
        System.out.println("Ppositive: ");
        System.out.println(Arrays.toString(positive));
        System.out.println("Negative: ");
        System.out.println(Arrays.toString(negative));

    }
}
