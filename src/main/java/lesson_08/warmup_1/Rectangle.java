package lesson_08.warmup_1;

public class Rectangle extends Figure{
    Point left;
    Point right;

    public Rectangle(Point left, Point right) {
        this.left = left;
        this.right = right;
    }

    @Override
    double area() {
        return Math.abs(left.x - right.x) * Math.abs(left.x - right.x);
    }
}
