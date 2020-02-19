package lesson_07.ZooApp;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("Dog{name='%s'}", name);
    }
}
