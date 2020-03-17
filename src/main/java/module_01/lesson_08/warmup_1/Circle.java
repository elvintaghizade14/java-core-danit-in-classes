package module_01.lesson_08.warmup_1;

public class Circle extends Figure {
  double radius;
  Point center;

  public Circle(double radius, Point center) {
    this.radius = radius;
    this.center = center;
  }

  public static Circle rand() {
    return new Circle(Math.random()*10+1, Point.randPoint());
  }

  @Override
  double area() {
    return Math.PI * Math.pow(radius, 2);
  }

  @Override
  public String toString() {
    return String.format("Circle{radius=%s, center=%s}", radius, center);
  }
}
