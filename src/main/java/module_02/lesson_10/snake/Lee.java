package module_02.lesson_10.snake;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lee {
  private final int width;
  private final int height;
  private final int[][] board;
  private static final int EMPTY = 0;
  private static final int OBSTACLE = -10;
  private static final int START = -1;
  private final List<SPoint> deltas = Arrays.asList(
          SPoint.of(0, -1), SPoint.of(-1, 0),
          SPoint.of(0, 1), SPoint.of(1, 0));

  public Lee(int width, int height) {
    this.width = width;
    this.height = height;
    this.board = new int[height][width];
  }

  private int get(SPoint p) {
    return board[p.y][p.x];
  }

  private void set(SPoint p, int value) {
    board[p.y][p.x] = value;
  }

  private boolean isOnBoard(SPoint p) {
    return p.x >= 0 && p.y >= 0 && p.x < width && p.y < height;
  }

  private boolean isUnvisited(SPoint p) {
    return get(p) == EMPTY;
  }

  private Stream<SPoint> neighbours(SPoint p) {
    return deltas.stream().map(d -> d.move(p)).filter(this::isOnBoard);
  }

  private Set<SPoint> neighboursUnvisited(SPoint p) {
    return neighbours(p).filter(this::isUnvisited).collect(Collectors.toSet());
  }

  private List<SPoint> neighboursByValue(SPoint point, int value) {
    return neighbours(point).filter(p -> get(p) == value).collect(Collectors.toList());
  }

  private void initBoard(List<SPoint> obstacles) {
    IntStream.range(0, width).boxed().flatMap(x ->
            IntStream.range(0, height).mapToObj(y ->
                    SPoint.of(x, y)
            )
    ).forEach(p -> set(p, EMPTY));
    obstacles.forEach(p -> set(p, OBSTACLE));
  }

  public Optional<List<SPoint>> path(SPoint start, SPoint finish, List<SPoint> obstacles) {
    initBoard(obstacles);
    boolean found = false;
    set(start, START);
    Set<SPoint> curr = new HashSet<>();
    curr.add(start);
    int[] counter = {0};
    while (!(curr.isEmpty() || found)) {
      counter[0]++;
      Set<SPoint> next = curr.stream()
              .map(this::neighboursUnvisited)
              .flatMap(Collection::stream)
              .collect(Collectors.toSet());
      next.forEach(p -> set(p, counter[0]));
      found = next.contains(finish);
      printMe(Collections.emptyList());
      curr.clear();
      curr.addAll(next);
    }
    if (!found) return Optional.empty();
    LinkedList<SPoint> path = new LinkedList<>();
    path.add(finish);
    set(start, 0);
    SPoint curr_p = finish;
    while (counter[0] > 0) {
      counter[0]--;
      SPoint prev_p = neighboursByValue(curr_p, counter[0]).get(0);
      path.addFirst(prev_p);
      curr_p = prev_p;
    }
    printMe(path);
    return Optional.empty();
  }

  public String formatted(SPoint p, List<SPoint> path) {
    int value = get(p);
    if (value == OBSTACLE) return " XX";
    if (path.isEmpty()) return String.format("%3d", value);
    if (path.contains(p)) return String.format("%3d", value);
    return "--";
  }

  void printMe(List<SPoint> path) {
    String s = IntStream.range(0, height).mapToObj(y ->
            IntStream.range(0, width)
                    .mapToObj(x -> SPoint.of(x, y))
                    .map(p -> formatted(p, path))
                    .collect(Collectors.joining())
    ).collect(Collectors.joining("\n"));
    System.out.printf("%s\n\n", s);
  }

}