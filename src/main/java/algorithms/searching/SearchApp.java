package algorithms.searching;

import algorithms.utils.RandnumGen;

import java.util.Arrays;

public class SearchApp {
  public static void main(String[] args) {
    RandnumGen gen = new RandnumGen(0, 1000, 1000);
    int[] origin = gen.genRandNums().toArray();
    int index = gen.genIndex();
    System.out.println(Arrays.toString(origin));

    // will find:
    linearSearch(origin, origin[index]);
    binarySearch(origin, origin[index]);

    // will not find:
    linearSearch(origin, 10000);
    binarySearch(origin, 10000);
  }

  private static void linearSearch(int[] origin, int num) {
    System.out.println("*************");
    System.out.printf("Linear search for %d\n", num);
    int comp_count = 0;
    for (int value : origin) {
      comp_count++;
      if (num == value) {
        System.out.printf("Number of comparisons: %d\n", comp_count);
        System.out.printf("Number->%d = %d<-array's element\n", num, value);
        return;
      }
    }
    System.out.printf("Number %d not found in array\n", num);
    System.out.printf("Program did %d comparisons\n", comp_count);
    System.out.println("*************");
  }

  private static void binarySearch(int[] origin, int num) {
    System.out.println("*************");
    System.out.printf("Binary search for %d\n", num);
    int[] sorted = origin.clone();
    Arrays.sort(sorted);
    int comp_count = 0;
    int left = 0;
    int right = sorted.length - 1;
    while (left <= right) {
      comp_count++;
      int mid_point = (left + right) / 2;
      if (num == sorted[mid_point]) {
        System.out.printf("Number of comparisons: %d\n", comp_count);
        System.out.printf("Number->%d = %d<-array's element\n", num, sorted[mid_point]);
        return;
      } else if (num > sorted[mid_point]) left = mid_point + 1;
      else if (num < sorted[mid_point]) right = mid_point - 1;
    }
    System.out.printf("Number %d not found in array\n", num);
    System.out.printf("Program did %d comparisons\n", comp_count);
    System.out.println("*************");
  }

}