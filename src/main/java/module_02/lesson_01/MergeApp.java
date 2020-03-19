package module_02.lesson_01;

import java.util.Arrays;
import java.util.Random;

public class MergeApp {
  public static void main(String[] args) {
    int[] data1 = new Random().ints(10, 30).limit(5).sorted().toArray();
    int[] data2 = new Random().ints(10, 30).limit(5).sorted().toArray();
    int[] data3 = merge(data1, data2);
    System.out.println(Arrays.toString(data1));
    System.out.println(Arrays.toString(data2));
    System.out.println(Arrays.toString(data3));
  }

  private static int[] merge(int[] data1, int[] data2) {
    int[] result = new int[data1.length + data2.length];
    int i = 0;
    int j = 0;
    int l = 0;
    for (i = 0; i < data1.length; i++) result[l++] = Math.min(data1[i], data2[i]);
    for (; j < data1.length; i++) result[l++] = data1[i];
    return result;
  }
}
