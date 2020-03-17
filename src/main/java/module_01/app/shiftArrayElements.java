package module_01.app;

import java.util.Arrays;

public class shiftArrayElements {
    public static void main(String[] args) {
        final int N = 5;
        final int[] arr = new int[N];

        fillArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shiftElements(arr)));

    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101 - 1);
        }
    }

    private static int[] shiftElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
        }
        return arr;
    }
}
