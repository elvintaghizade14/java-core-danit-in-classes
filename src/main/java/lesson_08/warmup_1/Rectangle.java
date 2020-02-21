package lesson_08.warmup_1;

public class Rectangle extends Figure{
  Point left;
  Point right;

  public Rectangle(Point left, Point right) {
    this.left = left;
    this.right = right;
  }

  public static Rectangle rand() {
    return new Rectangle(Point.randPoint(), Point.randPoint());
  }

  @Override
  double area() {
    return Math.abs(left.x - right.x) * Math.abs(left.x - right.x);
  }
}
