package lesson_08.warmup_1;

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
}
