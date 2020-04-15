package algorithms.sorting;

import algorithms.utils.RandnumGen;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    RandnumGen gen = new RandnumGen(0, 1000, 20);
    int[] origin = gen.genRandNums().toArray();

    System.out.println(Arrays.toString(origin));

    int[] sorted = bubbleSort(origin);
    System.out.println(Arrays.toString(sorted));

    Arrays.sort(origin);
    int[] sorted2 = bubbleSortImproved(origin);
    System.out.println(Arrays.toString(sorted2));
  }

  public static int[] bubbleSort(int[] origin) {
    int[] sorted = origin.clone();
    int comp_count = 0;
    for (int i = 0; i < sorted.length - 1; i++) {
      for (int j = 0; j < sorted.length - 1 - i; j++) {
        comp_count++;
        if (sorted[j] > sorted[j + 1]) {
          int tmp = sorted[j];
          sorted[j] = sorted[j + 1];
          sorted[j + 1] = tmp;
        }
      }
    }
    System.out.printf("Number of comparisons: %d\n", comp_count);
    return sorted;
  }

  private static int[] bubbleSortImproved(int[] origin) {
    int[] sorted = origin.clone();
    boolean isSorted = true;
    int comp_count = 0;

    for (int i = 0; i < sorted.length - 1; i++) {
      for (int j = 0; j < sorted.length - 1 - i; j++) {
        comp_count++;
        if (sorted[j] > sorted[j + 1]) {
          int tmp = sorted[j];
          sorted[j] = sorted[j + 1];
          sorted[j + 1] = tmp;
          isSorted = false;
        }
      }
      if (isSorted) {
        System.out.printf("Number of comparisons: %d\n", comp_count);
        return sorted;
      }
    }
    System.out.printf("Number of comparisons: %d\n", comp_count);
    return sorted;
  }
}