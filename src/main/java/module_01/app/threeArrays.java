package module_01.app;

import java.util.Arrays;

public class threeArrays {
    public static void main(String[] args) {
        // 1. declaring
        final int N = 10;
        int[] div2 = new int[N];
        int[] div7 = new int[N];
        int[] div11 = new int[N];
        final int allLen = 3 * N;
        int[] allNums = new int[allLen];

        // 2. processing
        fillArray(div2, 2);
        fillArray(div7, 7);
        fillArray(div11, 11);

        int counter = 0;
        for (int i = 0; i < N; i++) {
            allNums[counter] = div2[i];
            allNums[counter + 1] = div7[i];
            allNums[counter + 2] = div11[i];
            counter += 3;
        }

        // 3. printing
        System.out.println(Arrays.toString(div2));
        System.out.println(Arrays.toString(div7));
        System.out.println(Arrays.toString(div11));
        System.out.println(Arrays.toString(allNums));

    }

    private static void fillArray(int[] arr, int divider) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int) (Math.random() * 100)) * divider;
        }
    }

}
