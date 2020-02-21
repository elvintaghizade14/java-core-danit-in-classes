package lesson_08.warmup_1;

public class Triangle extends Figure {
  Point p1;
  Point p3;
  Point p2;

  public Triangle(Point p1, Point p3, Point p2) {
    this.p1 = p1;
    this.p3 = p3;
    this.p2 = p2;
  }

  public static Triangle rand() {
    return new Triangle(Point.randPoint(), Point.randPoint(), Point.randPoint());
  }

  @Override
  double area() {
    double l1 = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    double l2 = Math.sqrt(Math.pow(p3.x - p1.x, 2) + Math.pow(p3.y - p1.y, 2));
    return l2 * l1 / 2;
  }
}
