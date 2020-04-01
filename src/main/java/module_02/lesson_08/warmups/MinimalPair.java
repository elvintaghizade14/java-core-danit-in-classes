package module_02.lesson_08.warmups;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MinimalPair {
  public static void main(String[] args) {
    List<Integer> numbers = new Random().ints(0, 51)
            .limit(30)
            .boxed()
            .collect(Collectors.toList());

    int index = 0;
    int num1 = numbers.get(0);
    int num2 = numbers.get(1);
    int sum = num1 + num2;

    for (int i = 0; i < numbers.size() - 1; i++) {
      int nextSum = numbers.get(i) + numbers.get(i);
      if (sum < nextSum) {
        sum = nextSum;
        num1 = numbers.get(i);
        num2 = numbers.get(i + 1);
        index = numbers.indexOf(num1);
      }
    }

    System.out.printf("index of pair: %d\n", index);
    System.out.printf("Number 1:      %d\n", num1);
    System.out.printf("Number 2:      %d\n", num2);
    System.out.printf("Sum:           %d\n", sum);
  }
}
