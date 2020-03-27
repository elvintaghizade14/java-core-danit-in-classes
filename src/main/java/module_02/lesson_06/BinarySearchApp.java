package module_02.lesson_06;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchApp {
  static int[] unsorted = new Random().ints(0, 10000).limit(1000).toArray();
  static int[] sorted = unsorted.clone();

  // count number of `if` statements
  // executed to find the given element
  static int find_conventional(int[] origin, int number) {
    int counter = 0;
    // write your code here
    for (int value : origin) {
      counter++;
      if (number == value) return counter;
    }
    return counter;
  }

  // count number of `if` statements
  // executed to find the given element
  static int find_binary(int[] origin, int number) {
    int counter = 0;
    // write your code here
    int l = 0;
    int r = origin.length - 1;
    if (number < origin[l]) return counter+1;
    if (number > origin[r]) return counter+1;
    while (l <= r) {
      counter++;
      int mid = (l + r) / 2;
      if (number == origin[mid]) return counter;
      if (number < origin[mid]) r = mid - 1;
      else if (number > origin[mid]) l = mid + 1;
      else return counter;
    }
    return counter;
  }

  public static void main(String[] args) {
    Arrays.sort(sorted);
    System.out.println(Arrays.toString(unsorted));
    System.out.println(Arrays.toString(sorted));
    int rnd = sorted[(int) (Math.random() * 1000)];
    int count1 = find_conventional(unsorted, rnd);
    System.out.printf("Conventional: %d\n", count1);
    int count2 = find_binary(sorted, rnd);
    System.out.printf("Conventional: %d", count2);
  }
}
