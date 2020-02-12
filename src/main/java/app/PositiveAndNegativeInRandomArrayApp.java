package app;

public class PositiveAndNegativeInRandomArrayApp {
    public static void main(String[] args) {
        final int LEN = 30;

        int[] arr = new int[LEN];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 201 - 100);
        }
        for (int el : arr) {
            System.out.print(el + " ");
        }

    }
}
