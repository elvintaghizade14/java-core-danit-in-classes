package module_02.lesson_10.snake;

import java.util.Objects;

public class SPoint {
  public final int x;
  public final int y;

  public SPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static SPoint of(int x, int y) {
    return new SPoint(x, y);
  }

  public SPoint move(SPoint delta) {
    return SPoint.of(x + delta.x, y + delta.y);
  }

  @Override
  public String toString() {
    return String.format("[x=%2d, y=%2d]", x, y);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SPoint sPoint = (SPoint) o;
    return x == sPoint.x &&
            y == sPoint.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}