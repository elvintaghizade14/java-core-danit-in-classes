package module_02.lesson_09.warmups;

import java.util.Arrays;

public class ShipmentsApp {

  static int fix(int[] w) {
    int len = w.length;
    int sum = Arrays.stream(w, 0, len).sum();
    if (sum % len != 0) return -1;
    int avg = sum / len;
    int count = 0;
    for (int item : w) {
      if (item < avg) count += avg - item;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a1 = {1, 1, 1, 1, 6};
    int[] a2 = {1, 1, 1, 1, 16};
    int[] a3 = {1, 1, 1, 1, 15};
    int[] a4 = {10, 20, 2, 3, 15};
    System.out.println(fix(a1)); // 4
    System.out.println(fix(a2)); // 12
    System.out.println(fix(a3)); // -1
    System.out.println(fix(a4)); // 15
  }
}
