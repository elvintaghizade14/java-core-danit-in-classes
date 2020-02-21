package lesson_08.warmup_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, new Point(1, 2));
        Rectangle rectangle = new Rectangle(new Point(10, 15), new Point(20, 9));
        Triangle triangle = new Triangle(new Point(0, 0), new Point(5, 5), new Point(10, 0));
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(circle);
        figures.add(rectangle);
        figures.add(triangle);
        for (Figure f:figures) {
            System.out.println(f.area());
        }
    }
}
