package lesson_08.warmup_1;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

//    Circle circle = new Circle(5, new Point(1, 2));
//    Rectangle rectangle = new Rectangle(new Point(10, 15), new Point(20, 9));
//    Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 5), new Point(10, 0));

    ArrayList<Figure> figures = new ArrayList<>();

    figures.add(chooseFigure());
    figures.add(chooseFigure());
    figures.add(chooseFigure());

    double total = 0;
    for (Figure f : figures) {
      total += f.area();
    }
    System.out.printf("Total area is: %s\n", total);
  }

  private static Figure chooseFigure() {
    switch ((int) (Math.random() * 3)) {
      case 0:
        return Triangle.rand();
      case 1:
        return Rectangle.rand();
      case 2:
      default:
        return Circle.rand();
    }

  }
}
