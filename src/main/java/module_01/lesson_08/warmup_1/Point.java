package module_01.lesson_08.warmup_1;

public class Point {
  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static Point randPoint() {
    return new Point(Math.random() * 20, Math.random() * 20);
  }

  @Override
  public String toString() {
    return String.format("Point{x=%s, y=%s}", x, y);
  }
}
