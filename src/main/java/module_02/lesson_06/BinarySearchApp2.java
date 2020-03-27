package module_02.lesson_06;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchApp2 {
  static int[] unsorted = new Random().ints(0, 10000).limit(1000).toArray();
  static int[] sorted = unsorted.clone();

  // count number of `if` statements
  // executed to find the given element
  // find though unsorted data
  // return: 1. boolean-found, 2.int-index, 3.int -num of ops.
  static Result find_conventional(int[] origin, int number) {
    int counter = 0;
    for (int i = 0; i < origin.length; i++) {
      int el = origin[i];
      counter++;
      if (el == number) return new Result(true, i, counter);
    }
    return new Result(false);
  }

  // count number of `if` statements
  // executed to find the given element
  // find through sorted data
  // return: 1. boolean-found, 2.int-index, 3.int -num of ops.
  static Result find_binary(int[] origin, int number) {
    int counter = 0;
    int l = 0;
    int r = origin.length - 1;
    while (l <= r) {
      counter++;
      int m = (l+r)/2;
      if (number == origin[m]) return new Result(true, m, counter);
      if (number < origin[m]) r = m - 1;
      // (number > origin[m])
      else l = m + 1;
    }
    return new Result(false);
  }

  public static void main(String[] args) {
    Arrays.sort(sorted);
    System.out.println(Arrays.toString(unsorted));
    System.out.println(Arrays.toString(sorted));
    int rnd = sorted[(int) (Math.random()*1000)];
    Result conventional = find_conventional(unsorted, rnd);
    Result binary = find_binary(sorted, rnd);
    System.out.println(conventional.represent());
    System.out.println(binary.represent());
  }
}
