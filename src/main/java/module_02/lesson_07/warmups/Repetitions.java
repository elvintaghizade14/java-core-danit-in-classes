package module_02.lesson_07.warmups;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;

public class Repetitions {
  public static void main(String[] args) {
    int[] nums = new Random()
            .ints(10, 26)
            .limit(50).toArray();
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
}
