package module_02.lesson_10.warmups;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parking {
  public static long carParkingRoof(List<Long> cars, int k) {
    List<Long> sorted = cars.stream().sorted().collect(Collectors.toList());
    return IntStream.rangeClosed(0, sorted.size() - k)
            .mapToLong(i -> sorted.get(i + k - 1) - sorted.get(i + 1))
            .min().orElseThrow(RuntimeException::new);
  }

  public static void main(String[] args) {
    List<Long> cars = Arrays.asList(6L, 2L, 12L, 7L);
    long r = carParkingRoof(cars, 3);
    System.out.println(r); // 6
  }
}