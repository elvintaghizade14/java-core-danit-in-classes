package module_02.lesson_08.warmups;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MinimalPair {
  public static void main(String[] args) {
    List<Integer> data = new Random().ints(0, 51)
            .limit(30)
            .boxed()
            .collect(Collectors.toList());

    int index = 0;
    int num1 = data.get(0);
    int num2 = data.get(1);
    int sum = num1 + num2;

    for (int i = 1; i < data.size() - 1; i++) {
      int nextSum = data.get(i) + data.get(i);
      if (sum > nextSum) {
        index = i;
        num1 = data.get(i);
        num2 = data.get(i + 1);
        sum = nextSum;
      }
    }

    System.out.println(data);
    System.out.printf("index of pair: %d\n", index);
    System.out.printf("Number 1:      %d\n", num1);
    System.out.printf("Number 2:      %d\n", num2);
    System.out.printf("Sum:           %d\n", num1 + num2);
  }
}
