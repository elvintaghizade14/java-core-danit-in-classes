package module_02.lesson_07.warmups;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Repetitions {
  public static void main(String[] args) {
    int[] nums = randGen(10, 25, 50);
    Map<Integer, Integer> counts = new HashMap<>();
    int min = nums[0];
    for (int num : nums) {
      int counter = 1;
      for (int i : nums) {
        if (num == i) counter++;
      }
      counts.put(num, counter);
      if (min > num) min = num;
    }
    System.out.printf("Number: %d, repetitions: %d",min, counts.get(min));
  }

  private static int[] randGen(int left, int right, int limit) {
    return new Random().ints(left, right+1).limit(limit).toArray();
  }
}
