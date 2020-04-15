package algorithms.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class RandnumGen {
  private final int left_bound;   // inclusive
  private final int right_bound;  // exclusive
  private final int nums_count;   // count of random numbers

  public RandnumGen(int left_bound, int right_bound, int nums_count) {
    this.left_bound = left_bound;
    this.right_bound = right_bound;
    this.nums_count = nums_count;
  }

  public IntStream genRandNums() {
    return new Random().ints(nums_count, left_bound, right_bound + 1);
  }

  public int genIndex() {
    return new Random().nextInt(nums_count);
  }
}