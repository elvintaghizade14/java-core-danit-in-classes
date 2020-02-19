package lesson_07.ZooApp;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Cat{name='%s'}", name);
    }
}
