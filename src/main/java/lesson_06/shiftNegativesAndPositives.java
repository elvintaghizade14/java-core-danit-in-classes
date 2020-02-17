package lesson_06;

import java.util.Arrays;

public class shiftNegativesAndPositives {
    public static void main(String[] args) {
        final int N = 10;
        final int[] arr = new int[N];
        int countNeg = fillArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shiftElements(arr, countNeg)));
    }

    private static int fillArray(int[] arr) {
        int countNeg = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 21 - 10);
            if (arr[i] < 0) countNeg++;
        }
        return countNeg;
    }

    private static int[] shiftElements(int[] arr, int countNeg) {
        if (countNeg < 2) return arr;
        else {
            int[] posIndx = new int[arr.length - countNeg];
            int counter = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    posIndx[counter] = i;
                    counter++;
                }
            }
            for (int i = posIndx.length - 1; i > 0; i--) {
                int tmp = arr[posIndx[i]];
                arr[posIndx[i]] = arr[posIndx[i - 1]];
                arr[posIndx[i - 1]] = tmp;
            }
            return arr;
        }
    }
}



