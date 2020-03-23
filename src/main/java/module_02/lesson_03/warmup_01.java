package module_02.lesson_03;

import java.util.Arrays;
import java.util.Random;

public class warmup_01 {
  private static int index = 0;

  public static int sum(int[] data, int index) {
    if (data.length <= index) return 0;
    return data[index] + sum(data, index+1);
  }


  public static int sum(int[] data) {
    return sum(data, index++);
  }

  public static void main(String[] args) {
    // our random data
    int[] d = new Random().ints(1, 10).limit(3).toArray();
    System.out.printf("Source array: %s\n", Arrays.toString(d));
    System.out.printf("Sum: %d\n", sum(d));
  }
}
