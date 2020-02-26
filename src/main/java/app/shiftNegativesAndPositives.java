package app;

import java.util.Arrays;

public class shiftNegativesAndPositives {
    public static void main(String[] args) {
        // 1. declaring
        final int N = 20;
        final int[] arr = new int[N];

        // 2. processing
        fillArray(arr);

        // 3. printing
        System.out.println(Arrays.toString(arr));
    }

    private static void fillArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 201 - 100);
        }
    }

}
