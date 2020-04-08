package module_02.lesson_10.snake;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeeApp {

  private static Stream<SPoint> horAt(int y, int x_from, int x_to) {
    return IntStream.rangeClosed(x_from, x_to).mapToObj(x -> SPoint.of(x, y));
  }

  private static Stream<SPoint> verAt(int x, int y_from, int y_to) {
    return IntStream.rangeClosed(y_from, y_to).mapToObj(y -> SPoint.of(x, y));
  }

  public static List<SPoint> obstacles() {
    return Stream.of(
            verAt(7, 0, 7),
            horAt(7, 0, 1),
            horAt(7, 3, 6),
            verAt(15, 1, 14)
    ).flatMap(x -> x).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    SPoint curr = null;
    Lee lee = new Lee(20, 15);
    SPoint from = SPoint.of(0,0);
    SPoint to = SPoint.of(19,14);
    Optional<List<SPoint>> path = lee.path(from, to, obstacles());
    System.out.println(path);
  }
}
